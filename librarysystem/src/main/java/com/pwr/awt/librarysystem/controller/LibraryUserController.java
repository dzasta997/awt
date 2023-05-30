package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.LibraryUserDTO;
import com.pwr.awt.librarysystem.entity.LibraryUser;
import com.pwr.awt.librarysystem.mapper.LibraryUserMapper;
import com.pwr.awt.librarysystem.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class LibraryUserController {
    private final LibraryUserMapper libraryUserMapper;
    private final LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserController(LibraryUserMapper libraryUserMapper, LibraryUserService libraryUserService) {
        this.libraryUserMapper = libraryUserMapper;
        this.libraryUserService = libraryUserService;
    }

    @GetMapping
    public ResponseEntity<List<LibraryUserDTO>> getAllLibraryUsers() {
        List<LibraryUser> libraryUsers = libraryUserService.findAll();
        return new ResponseEntity<>(libraryUserMapper.toDto(libraryUsers), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryUserDTO> getLibraryUser(@PathVariable long id) {
        LibraryUser libraryUser = libraryUserService.findByLibraryUserId(id);
        return new ResponseEntity<>(libraryUserMapper.toDto(libraryUser), HttpStatus.OK);
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<LibraryUserDTO> postLibraryUser(@RequestBody LibraryUserDTO libraryUserDTO) {
        LibraryUser libraryUserSaved = libraryUserService.saveLibraryUser(libraryUserMapper.toEntity(libraryUserDTO));
        return new ResponseEntity<>(libraryUserMapper.toDto(libraryUserSaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteLibraryUser(@PathVariable long id) {
        libraryUserService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user")
    public ResponseEntity<String> currentUsername(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return new ResponseEntity( username, HttpStatus.OK);
    }


}
