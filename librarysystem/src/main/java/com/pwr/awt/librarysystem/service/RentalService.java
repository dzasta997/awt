package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Rental;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(final RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
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
}
