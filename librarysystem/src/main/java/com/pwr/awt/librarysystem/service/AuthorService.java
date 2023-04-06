package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Address;
import com.pwr.awt.librarysystem.entity.Author;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findByAuthorId(long id) {
        return authorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!authorRepository.existsById(id)){
            throw new OperationException();
        }
        authorRepository.deleteById(id);
    }
    public Author saveAuthor(Author author) {
        if (author.getAuthorId() != null && authorRepository.existsById(author.getAuthorId())) {
            throw new OperationException();
        }
        return authorRepository.save(author);
    }

}
