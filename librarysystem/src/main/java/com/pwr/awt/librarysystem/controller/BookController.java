package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.BookDTO;
import com.pwr.awt.librarysystem.entity.Author;
import com.pwr.awt.librarysystem.entity.Book;
import com.pwr.awt.librarysystem.entity.Category;
import com.pwr.awt.librarysystem.mapper.AuthorMapper;
import com.pwr.awt.librarysystem.mapper.BookMapper;
import com.pwr.awt.librarysystem.mapper.CategoryMapper;
import com.pwr.awt.librarysystem.service.AuthorService;
import com.pwr.awt.librarysystem.service.BookService;
import com.pwr.awt.librarysystem.service.CategoryService;
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
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;
    private final AuthorMapper authorMapper;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookMapper bookMapper, BookService bookService, CategoryMapper categoryMapper, CategoryService categoryService, AuthorMapper authorMapper, AuthorService authorService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(bookMapper.toDto(books), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> postBook(@RequestBody BookDTO bookDTO) {
        Book bookSaved = bookService.saveBook(bookMapper.toEntity(bookDTO));
        return new ResponseEntity<>(bookMapper.toDto(bookSaved), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable long id) {
        Book book = bookService.findByBookId(id);
        return new ResponseEntity<>(bookMapper.toDto(book), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        Book book = bookService.findByBookId(id);
        Book updated = bookMapper.toEntity(bookDTO.setBookId(book.getBookId()));
        return new ResponseEntity<>(bookMapper.toDto(updated), HttpStatus.OK);
    }

    @PutMapping("/{id}/categories/{categoryId}")
    public ResponseEntity<BookDTO> addCategory(@PathVariable long id, @PathVariable long categoryId) {
        Book book = bookService.findByBookId(id);
        Category category = categoryService.findByCategoryId(categoryId);
        Book updated = bookService.addBookCategory(book, category);
        return new ResponseEntity<>(bookMapper.toDto(updated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/categories/{categoryId}")
    public ResponseEntity<BookDTO> removeCategory(@PathVariable long id, @PathVariable long categoryId) {
        Book book = bookService.findByBookId(id);
        Category category = categoryService.findByCategoryId(categoryId);
        Book updated = bookService.removeBookCategory(book, category);
        return new ResponseEntity<>(bookMapper.toDto(updated), HttpStatus.OK);
    }

    @PutMapping("/{id}/authors/{authorId}")
    public ResponseEntity<BookDTO> addAuthor(@PathVariable long id, @PathVariable long authorId) {
        Book book = bookService.findByBookId(id);
        Author author = authorService.findByAuthorId(authorId);
        Book updated = bookService.addBookAuthor(book, author);
        return new ResponseEntity<>(bookMapper.toDto(updated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/authors/{authorId}")
    public ResponseEntity<BookDTO> removeAuthor(@PathVariable long id, @PathVariable long authorId) {
        Book book = bookService.findByBookId(id);
        Author author = authorService.findByAuthorId(authorId);
        Book updated = bookService.removeBookAuthor(book, author);
        return new ResponseEntity<>(bookMapper.toDto(updated), HttpStatus.OK);
    }





}
