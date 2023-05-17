package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.entity.LibraryUser;
import com.pwr.awt.librarysystem.entity.Rental;
import com.pwr.awt.librarysystem.enumeration.RentalStatus;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.LibraryUserRepository;
import com.pwr.awt.librarysystem.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final LibraryUserRepository libraryUserRepository;

    @Autowired
    public RentalService(final RentalRepository rentalRepository, LibraryUserRepository libraryUserRepository) {
        this.rentalRepository = rentalRepository;
        this.libraryUserRepository = libraryUserRepository;
    }

    public List<Rental> findAll(Optional<RentalStatus> status) {
        if (status.isEmpty()){
            return rentalRepository.findAll();
        }
        return rentalRepository.findByStatus(status.get());
    }

    public Rental findByRentalId(long id) {
        return rentalRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!rentalRepository.existsById(id)){
            throw new OperationException();
        }
        rentalRepository.deleteById(id);
    }
    public Rental saveRental(Rental rental) {
        if (rental.getRentalId() != null && rentalRepository.existsById(rental.getRentalId())) {
            throw new OperationException();
        }
        return rentalRepository.save(rental);
    }

    public Rental updateRental(long id, Rental rental) {
        if (!rentalRepository.existsById(id)) {
            throw new OperationException();
        }
        Rental rentalDB = rentalRepository.findById(id).get();
        if(rental.getStatus() != null){
            rentalDB.setStatus(rental.getStatus());
        }
        if(rental.getStatus() == RentalStatus.RETURNED){
            rentalDB.setReturnDate(LocalDate.now());
        }
        return rentalRepository.save(rentalDB);
    }

    public Rental addRental(Copy copy){
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        LibraryUser libraryUser = libraryUserRepository.findByUsername(username);
        Rental rental = new Rental()
                .setRentalDate(LocalDate.now())
                .setDueDate(LocalDate.now().plusDays(30))
                .setStatus(RentalStatus.RESERVED)
                .setCopy(copy)
                .setLibraryUser(libraryUser);
        return rentalRepository.save(rental);
    }

    public List<Rental> userRentals(Optional<RentalStatus> status){
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (status.isEmpty()){
            return rentalRepository.findByLibraryUser_Username(username);
        }
        return rentalRepository.findByLibraryUser_UsernameAndStatus(username, status.get());

    }

}
