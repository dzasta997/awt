package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.entity.LibraryUser;
import com.pwr.awt.librarysystem.entity.Rental;
import com.pwr.awt.librarysystem.enumeration.RentalStatus;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.CopyRepository;
import com.pwr.awt.librarysystem.repository.LibraryUserRepository;
import com.pwr.awt.librarysystem.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final CopyRepository copyRepository;
    private final LibraryUserRepository libraryUserRepository;

    @Autowired
    public RentalService(final RentalRepository rentalRepository, CopyRepository copyRepository, LibraryUserRepository libraryUserRepository) {
        this.rentalRepository = rentalRepository;
        this.copyRepository = copyRepository;
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
            sendReturnEmail(rentalDB.getLibraryUser(), rentalDB.getCopy());
            rentalDB.getCopy().setRented(false);
//            copyRepository.save(rentalDB.getCopy().setRented(false));
        }
        rentalRepository.save(rentalDB);
        return rentalDB;
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
        sendReserveEmail(libraryUser, copy);
        copyRepository.save(copy.setRented(true));
        return rentalRepository.save(rental);
    }



    public List<Rental> userRentals(Optional<RentalStatus> status){
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (status.isEmpty()){
            return rentalRepository.findByLibraryUser_Username(username);
        }
        return rentalRepository.findByLibraryUser_UsernameAndStatus(username, status.get());

    }

    public void sendReserveEmail(LibraryUser libraryUser, Copy copy){
        String title = copy.getBook().getTitle();
        String name = libraryUser.getUserInfo().getFirstName();
        String email = libraryUser.getUserInfo().getEmail();
        String subject = "BOOK_RESERVATION";
        String command = String.format("python3 scrips/reserveemail.py %s %s %s %s", email,name, subject, title );
        sendEmail(command);
    }

    public void sendReturnEmail(LibraryUser libraryUser, Copy copy){
        String title = copy.getBook().getTitle();
        String name = libraryUser.getUserInfo().getFirstName();
        String email = libraryUser.getUserInfo().getEmail();
        String subject = "BOOK_RESERVATION";
        String command = String.format("python3 scrips/returnemail.py %s %s %s %s", email,name, subject, title );
        sendEmail(command);
    }

    public void sendEmail(String command){

            try {
                Process process = Runtime.getRuntime().exec(command);
                process.waitFor();
                System.out.println(new BufferedReader(new InputStreamReader(process.getInputStream())).readLine());
            } catch (Exception e) {
                System.out.println(e.getCause());
            }

    }

}
