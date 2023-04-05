package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.BookDTO;
import com.pwr.awt.librarysystem.entity.Book;
import com.pwr.awt.librarysystem.mapper.BookMapper;
import com.pwr.awt.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    private final BookMapper bookMapper;
    private final BookService bookService;

    @Autowired
    public BookController(BookMapper bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(bookMapper.toDto(books), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable long id) {
        Book book = bookService.findByBookId(id);
        return new ResponseEntity<>(bookMapper.toDto(book), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> postBook(@RequestBody BookDTO bookDTO) {
        Book bookSaved = bookService.saveBook(bookMapper.toEntity(bookDTO));
        return new ResponseEntity<>(bookMapper.toDto(bookSaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
