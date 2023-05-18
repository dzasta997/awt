package com.pwr.awt.librarysystem.dto;

import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.entity.LibraryUser;
import com.pwr.awt.librarysystem.enumeration.RentalStatus;

import java.time.LocalDate;

public class RentalDTO {
    private Long rentalId;
    private LocalDate rentalDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private RentalStatus status;
    private CopyDTO copy;
    private LibraryUserDTO libraryUser;

    public RentalDTO() {
    }

    public Long getRentalId() {
        return rentalId;
    }

    public RentalDTO setRentalId(Long rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public RentalDTO setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public RentalDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public RentalDTO setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public RentalDTO setStatus(RentalStatus status) {
        this.status = status;
        return this;
    }

    public CopyDTO getCopy() {
        return copy;
    }

    public RentalDTO setCopy(CopyDTO copy) {
        this.copy = copy;
        return this;
    }

    public LibraryUserDTO getLibraryUser() {
        return libraryUser;
    }

    public RentalDTO setLibraryUser(LibraryUserDTO libraryUser) {
        this.libraryUser = libraryUser;
        return this;
    }
}
