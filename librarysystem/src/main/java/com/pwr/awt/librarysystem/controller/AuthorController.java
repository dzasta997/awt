package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.AuthorDTO;
import com.pwr.awt.librarysystem.entity.Author;
import com.pwr.awt.librarysystem.mapper.AuthorMapper;
import com.pwr.awt.librarysystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("authors")
public class AuthorController {
    private final AuthorMapper authorMapper;
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorMapper authorMapper, AuthorService authorService) {
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authorMapper.toDto(authors), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable long id) {
        Author author = authorService.findByAuthorId(id);
        return new ResponseEntity<>(authorMapper.toDto(author), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> postAuthor(@RequestBody AuthorDTO authorDTO) {
        Author authorSaved = authorService.saveAuthor(authorMapper.toEntity(authorDTO));
        return new ResponseEntity<>(authorMapper.toDto(authorSaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable long id) {
        authorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
