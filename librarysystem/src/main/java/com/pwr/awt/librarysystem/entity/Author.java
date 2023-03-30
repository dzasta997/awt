package com.pwr.awt.librarysystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long authorId;
    private String firstName;
    private String lastName;
    private String description;

    public Author() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Author setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Author setDescription(String description) {
        this.description = description;
        return this;
    }
}
