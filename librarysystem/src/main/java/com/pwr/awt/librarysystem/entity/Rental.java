package com.pwr.awt.librarysystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentalId;
    private LocalDate rentalDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean penalty;
    @ManyToOne
    @JoinColumn(name = "copy_id")
    private Copy copy;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private LibraryUser libraryUser;

    public Rental() {
    }

    public Long getRentalId() {
        return rentalId;
    }

    public Rental setRentalId(Long rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public Rental setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Rental setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Rental setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public boolean isPenalty() {
        return penalty;
    }

    public Rental setPenalty(boolean penalty) {
        this.penalty = penalty;
        return this;
    }

    public Copy getCopy() {
        return copy;
    }

    public Rental setCopy(Copy copy) {
        this.copy = copy;
        return this;
    }

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public Rental setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
        return this;
    }
}
