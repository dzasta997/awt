package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.LibraryUser;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryUserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final LibraryUserRepository libraryUserRepository;

    @Autowired
    public LibraryUserService(final LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    public List<LibraryUser> findAll() {
        return libraryUserRepository.findAll();
    }

    public LibraryUser findByLibraryUserId(long id) {
        return libraryUserRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!libraryUserRepository.existsById(id)){
            throw new OperationException();
        }
        libraryUserRepository.deleteById(id);
    }
    public LibraryUser saveLibraryUser(LibraryUser libraryUser) {
        if (libraryUser.getUserId() != null && libraryUserRepository.existsById(libraryUser.getUserId())) {
            throw new OperationException();
        }
        libraryUser.setPassword(passwordEncoder.encode(libraryUser.getPassword()));
        return libraryUserRepository.save(libraryUser);
    }

}
