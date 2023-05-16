package com.pwr.awt.librarysystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long copyId;
    private String isbn;
    private String description;
    private LocalDate publicationYear;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean rented;

    public Copy() {
    }

    public Long getCopyId() {
        return copyId;
    }

    public Copy setCopyId(Long copyId) {
        this.copyId = copyId;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Copy setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Copy setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public Copy setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public Book getBook() {
        return book;
    }

    public Copy setBook(Book book) {
        this.book = book;
        return this;
    }

    public boolean isRented() {
        return rented;
    }

    public Copy setRented(boolean rented) {
        this.rented = rented;
        return this;
    }
}
