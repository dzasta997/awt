package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Author;
import com.pwr.awt.librarysystem.entity.Book;
import com.pwr.awt.librarysystem.entity.Category;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findByBookId(long id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!bookRepository.existsById(id)){
            throw new OperationException();
        }
        bookRepository.deleteById(id);
    }
    public Book saveBook(Book book) {
        if (book.getBookId() != null && bookRepository.existsById(book.getBookId())) {
            throw new OperationException();
        }
        return bookRepository.save(book);
    }

    public Book addBookCategory(Book book, Category category){
        if(book.getCategories().contains(category)){
            throw new OperationException("This category is already asigned to this book");
        }
        book.addCategory(category);
        bookRepository.save(book);
        return book;
    }

    public Book removeBookCategory(Book book, Category category){
        if(!book.getCategories().contains(category)){
            throw new OperationException("This category is not assigned to this book");
        }
        book.removeCategory(category);
        bookRepository.save(book);
        return book;
    }

    public Book addBookAuthor(Book book, Author author){
        if(book.getAuthors().contains(author)){
            throw new OperationException("This author is not assigned to this book");
        }
        book.addAuthor(author);
        bookRepository.save(book);
        return book;
    }

    public Book removeBookAuthor(Book book, Author author){
        if(!book.getAuthors().contains(author)){
            throw new OperationException("This author is already assigned to this book");
        }
        book.removeAuthor(author);
        bookRepository.save(book);
        return book;
    }

    public List<Book> searchBook(
                                Optional<String> firstName,
                                Optional<String> lastName,
                                Optional<String> category,
                                Optional<String> title
    ){
        return bookRepository.findByAuthors_FirstNameAndAuthors_LastNameAndCategories_NameAndTitle(firstName, lastName, category, title);
    }
}
