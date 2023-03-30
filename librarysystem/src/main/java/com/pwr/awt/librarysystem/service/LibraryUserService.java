package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserService {

    private final LibraryUserRepository libraryUserRepository;

    @Autowired
    public LibraryUserService(final LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }
}
