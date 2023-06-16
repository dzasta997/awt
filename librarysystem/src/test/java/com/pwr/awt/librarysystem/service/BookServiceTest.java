package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Author;
import com.pwr.awt.librarysystem.entity.Book;
import com.pwr.awt.librarysystem.entity.Category;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @InjectMocks
    BookService bookService;
    @Mock
    BookRepository bookRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    private Author author = new Author()
            .setAuthorId(1L)
            .setFirstName("Adam")
            .setLastName("Mickiewicz");

    private Category category = new Category()
            .setCategoryId(1L)
            .setName("historical");

    private Book savedBook = new Book()
            .setBookId(1L)
            .setTitle("Dziady");

    private Book categoryBook = new Book()
            .setBookId(1L)
            .setTitle("Dziady")
            .setCategories(new ArrayList<>(List.of(category)));

    private Book authorBook = new Book()
            .setBookId(1L)
            .setTitle("Dziady")
            .setAuthors(new ArrayList<>(List.of(author)));

    private Book newBook = new Book()
            .setTitle("Dziady");

    @Test
    public void findByIdPositiveCase(){
        when(bookRepository.findById(any())).thenReturn(Optional.of(savedBook));
        assertEquals(bookService.findByBookId(1L), savedBook);
    }

    @Test
    public void findByIdNegativeCase(){
        when(bookRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> bookService.findByBookId(2L));
    }

    @Test
    public void deleteByIdNegativeCase(){
        when(bookRepository.existsById(any())).thenReturn(false);
        assertThrows(OperationException.class, () -> bookService.deleteById(2L));
    }

    @Test
    public void savePositiveCase(){
        when(bookRepository.existsById(any())).thenReturn(false);
        when(bookRepository.save(any())).thenReturn(savedBook);
        assertEquals(bookService.saveBook(newBook), savedBook);
    }

    @Test
    public void saveNegativeCase(){
        when(bookRepository.existsById(any())).thenReturn(true);
        assertThrows(OperationException.class, () -> bookService.saveBook(savedBook));
    }

    @Test
    public void addCategoryPositiveCase(){
        when(bookRepository.save(any())).thenReturn(categoryBook);
        Book book = bookService.addBookCategory(savedBook, category);
        assertEquals(book.getCategories().size(), 1);
    }

    @Test
    public void addCategoryNegativeCase(){
        assertThrows(OperationException.class, () -> bookService.addBookCategory(categoryBook, category));
    }

    @Test
    public void removeCategoryPositiveCase(){
        when(bookRepository.save(any())).thenReturn(savedBook);
        Book book = bookService.removeBookCategory(categoryBook, category);
        assertEquals(book.getCategories().size(), 0);
    }

    @Test
    public void removeCategoryNegativeCase(){
        assertThrows(OperationException.class, () -> bookService.removeBookCategory(savedBook, category));
    }

    @Test
    public void addAuthorPositiveCase(){
        when(bookRepository.save(any())).thenReturn(authorBook);
        Book book = bookService.addBookAuthor(savedBook, author);
        assertEquals(book.getAuthors().size(), 1);
    }

    @Test
    public void addAuthorNegativeCase(){
        assertThrows(OperationException.class, () -> bookService.addBookAuthor(authorBook, author));
    }

    @Test
    public void removeAuthorPositiveCase(){
        when(bookRepository.save(any())).thenReturn(savedBook);
        Book book = bookService.removeBookAuthor(authorBook, author);
        assertEquals(book.getAuthors().size(), 0);
    }

    @Test
    public void removeAuthorNegativeCase(){
        assertThrows(OperationException.class, () -> bookService.removeBookAuthor(savedBook, author));
    }

}
