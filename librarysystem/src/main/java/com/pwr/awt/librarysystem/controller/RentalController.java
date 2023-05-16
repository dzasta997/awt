package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.CopyDTO;
import com.pwr.awt.librarysystem.dto.RentalDTO;
import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.entity.Rental;
import com.pwr.awt.librarysystem.mapper.CopyMapper;
import com.pwr.awt.librarysystem.mapper.RentalMapper;
import com.pwr.awt.librarysystem.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("rentals")
public class RentalController {
    private final RentalMapper rentalMapper;
    private final CopyMapper copyMapper;
    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalMapper rentalMapper, CopyMapper copyMapper, RentalService rentalService) {
        this.rentalMapper = rentalMapper;
        this.copyMapper = copyMapper;
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> getAllRentals() {
        List<Rental> rentals = rentalService.findAll();
        return new ResponseEntity<>(rentalMapper.toDto(rentals), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRental(@PathVariable long id) {
        Rental rental = rentalService.findByRentalId(id);
        return new ResponseEntity<>(rentalMapper.toDto(rental), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalDTO> postRental(@RequestBody RentalDTO rentalDTO) {
        Rental rentalSaved = rentalService.saveRental(rentalMapper.toEntity(rentalDTO));
        return new ResponseEntity<>(rentalMapper.toDto(rentalSaved), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<RentalDTO> postRental(@RequestBody CopyDTO copyDTO) {
        Copy copy = copyMapper.toEntity(copyDTO);
        Rental rental = rentalService.addRental(copy);
        return new ResponseEntity<>(rentalMapper.toDto(rental), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRental(@PathVariable long id) {
        rentalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RentalDTO>> getUserRental(){
        List<Rental> rentals = rentalService.userRentals();
        return new ResponseEntity<>(rentalMapper.toDto(rentals), HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<List<RentalDTO>> getUserCurrentRental(){
        List<Rental> rentals = rentalService.userCurrentRentals();
        return new ResponseEntity<>(rentalMapper.toDto(rentals), HttpStatus.OK);
    }

}
