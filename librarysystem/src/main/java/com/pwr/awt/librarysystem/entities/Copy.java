package com.pwr.awt.librarysystem.entities;

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
}
