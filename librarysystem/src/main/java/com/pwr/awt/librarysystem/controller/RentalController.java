package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.BookDTO;
import com.pwr.awt.librarysystem.dto.CopyDTO;
import com.pwr.awt.librarysystem.dto.RentalDTO;
import com.pwr.awt.librarysystem.entity.Copy;
import com.pwr.awt.librarysystem.entity.Rental;
import com.pwr.awt.librarysystem.enumeration.RentalStatus;
import com.pwr.awt.librarysystem.mapper.CopyMapper;
import com.pwr.awt.librarysystem.mapper.RentalMapper;
import com.pwr.awt.librarysystem.service.CopyService;
import com.pwr.awt.librarysystem.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("rentals")
public class RentalController {
    private final RentalMapper rentalMapper;
    private final CopyMapper copyMapper;
    private final RentalService rentalService;
    private final CopyService copyService;

    @Autowired
    public RentalController(RentalMapper rentalMapper, CopyMapper copyMapper, RentalService rentalService, CopyService copyService) {
        this.rentalMapper = rentalMapper;
        this.copyMapper = copyMapper;
        this.rentalService = rentalService;
        this.copyService = copyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RentalDTO>> getAllRentals(@RequestParam Optional<RentalStatus> status) {
        List<Rental> rentals = rentalService.findAll(status);
        return new ResponseEntity<>(rentalMapper.toDto(rentals), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRental(@PathVariable long id) {
        Rental rental = rentalService.findByRentalId(id);
        return new ResponseEntity<>(rentalMapper.toDto(rental), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDTO> changeRentalStatus(@PathVariable long id, @RequestBody RentalDTO rentalDTO ) {
        Rental updated = rentalService.updateRental(id, rentalMapper.toEntity(rentalDTO));
        return new ResponseEntity<>(rentalMapper.toDto(updated), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalDTO> postRental(@RequestBody RentalDTO rentalDTO) {
        Rental rentalSaved = rentalService.saveRental(rentalMapper.toEntity(rentalDTO));
        return new ResponseEntity<>(rentalMapper.toDto(rentalSaved), HttpStatus.OK);
    }

//    @PostMapping("/new")
//    public ResponseEntity<RentalDTO> postRental(@RequestBody CopyDTO copyDTO) {
//        Copy copy = copyService.findByCopyId(copyDTO.getCopyId());
//        Rental rental = rentalService.addRental(copy);
//        return new ResponseEntity<>(rentalMapper.toDto(rental), HttpStatus.OK);
//    }

//    @PostMapping("/new")
//    public ResponseEntity<RentalDTO> postBookRental(@RequestBody BookDTO bookDTO) {
//        Copy copy = copyService.findByBookIdAndRented(bookDTO.getBookId());
//        Rental rental = rentalService.addRental(copy);
//        return new ResponseEntity<>(rentalMapper.toDto(rental), HttpStatus.OK);
//    }

        @PostMapping("/new")
    public ResponseEntity<RentalDTO> postRental(@RequestBody BookDTO bookDTO) {
        Copy copy = copyService.findByBookIdAndRented(bookDTO.getBookId());
        Rental rental = rentalService.addRental(copy);
        return new ResponseEntity<>(rentalMapper.toDto(rental), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRental(@PathVariable long id) {
        rentalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> getUserRental(@RequestParam Optional<RentalStatus> status){
        List<Rental> rentals = rentalService.userRentals(status);
        return new ResponseEntity<>(rentalMapper.toDto(rentals), HttpStatus.OK);
    }


}
