package com.pwr.awt.librarysystem.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId;
    private String title;
    private String description;
    @ManyToMany
    @JoinTable(name="book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
            )
    private List<Author> authors = new ArrayList<>();
    @ManyToMany
    @JoinTable(name="book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();
    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public Book setBookId(Long bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    public Book addAuthor(Author author){
        this.authors.add(author);
        return this;
    }

    public Book removeAuthor(Author author){
        this.authors.remove(author);
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Book setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Book addCategory(Category category){
        this.categories.add(category);
        return this;
    }

    public Book removeCategory(Category category){
        this.categories.remove(category);
        return this;
    }
}
