package com.pwr.awt.librarysystem.dto;

import java.time.LocalDate;

public class CopyDTO {
    private Long copyId;
    private String isbn;
    private String description;
    private LocalDate publicationYear;
    private BookDTO book;
    private boolean rented;



    public CopyDTO() {
    }

    public Long getCopyId() {
        return copyId;
    }

    public CopyDTO setCopyId(Long copyId) {
        this.copyId = copyId;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public CopyDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CopyDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public CopyDTO setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public BookDTO getBook() {
        return book;
    }

    public CopyDTO setBook(BookDTO book) {
        this.book = book;
        return this;
    }

    public boolean isRented() {
        return rented;
    }

    public CopyDTO setRented(boolean rented) {
        this.rented = rented;
        return this;
    }
}
