package com.pwr.awt.librarysystem.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

public class AuthorDTO {
    private Long authorId;
    private String firstName;
    private String lastName;
    private String description;

    public AuthorDTO() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public AuthorDTO setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public AuthorDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthorDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AuthorDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
