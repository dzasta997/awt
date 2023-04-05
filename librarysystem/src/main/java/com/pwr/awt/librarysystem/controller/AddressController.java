package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.AddressDTO;
import com.pwr.awt.librarysystem.entity.Address;
import com.pwr.awt.librarysystem.mapper.AddressMapper;
import com.pwr.awt.librarysystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("addresses")
public class AddressController {
    private final AddressMapper addressMapper;
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressMapper addressMapper, AddressService addressService) {
        this.addressMapper = addressMapper;
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<Address> addresses = addressService.findAll();
        return new ResponseEntity<>(addressMapper.toDto(addresses), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable long id) {
        Address address = addressService.findByAddressId(id);
        return new ResponseEntity<>(addressMapper.toDto(address), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDTO> postAddress(@RequestBody AddressDTO addressDTO) {
        Address addressSaved = addressService.saveAddress(addressMapper.toEntity(addressDTO));
        return new ResponseEntity<>(addressMapper.toDto(addressSaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
