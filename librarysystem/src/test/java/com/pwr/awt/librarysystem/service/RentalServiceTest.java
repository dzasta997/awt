package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.entity.Rental;
import com.pwr.awt.librarysystem.enumeration.RentalStatus;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.CopyRepository;
import com.pwr.awt.librarysystem.repository.LibraryUserRepository;
import com.pwr.awt.librarysystem.repository.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RentalServiceTest {

    @InjectMocks
    RentalService rentalService;
    @Mock
    RentalRepository rentalRepository;
    @Mock
    CopyRepository copyRepository;
    @Mock
    LibraryUserRepository libraryUserRepository;

    Copy copy = new Copy()
            .setCopyId(1l)
            .setRented(true);

    Rental newRental = new Rental()
            .setStatus(RentalStatus.RESERVED)
            .setCopy(copy);

    Rental savedRental = new Rental()
            .setRentalId(1L)
            .setStatus(RentalStatus.RESERVED)
            .setCopy(copy);

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findByIdNegativeCase(){
        when(rentalRepository.existsById(any())).thenReturn(true);
        assertThrows(OperationException.class, () -> rentalService.saveRental(savedRental));
    }

    @Test
    public void updateRentalPositiveCase(){
        Rental update = new Rental()
                .setStatus(RentalStatus.RENTED);
        when(rentalRepository.existsById(any())).thenReturn(true);
        when(rentalRepository.findById(any())).thenReturn(Optional.ofNullable(savedRental));
        when(rentalRepository.save(any())).thenReturn(any());
        Rental updated = rentalService.updateRental(1L, update);
        assertEquals(updated.getStatus(), RentalStatus.RENTED);
    }

    @Test
    public void updateRentalNegativeCase(){
        when(rentalRepository.existsById(any())).thenReturn(false);
        assertThrows(OperationException.class, () -> rentalService.updateRental(2L, new Rental()));
    }


}
