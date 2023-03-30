package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Address;
import com.pwr.awt.librarysystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

}
