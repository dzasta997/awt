package com.pwr.awt.librarysystem.dto;
import java.util.List;

import com.pwr.awt.librarysystem.entity.Author;
import com.pwr.awt.librarysystem.entity.Category;


public class BookDTO {
    private Long bookId;
    private String title;
    private String description;
    private List<AuthorDTO> authors;
    private List<CategoryDTO> categories;

    public BookDTO() {
    }

    public Long getBookId() {
        return bookId;
    }

    public BookDTO setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public BookDTO setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
        return this;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public BookDTO setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
        return this;
    }
}
