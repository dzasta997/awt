package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(final RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
}
