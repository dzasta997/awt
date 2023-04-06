package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Book;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
