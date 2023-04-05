package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Address;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
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
    public Address findByAddressId(long id) {
        return addressRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!addressRepository.existsById(id)){
            throw new OperationException();
        }
        addressRepository.deleteById(id);
    }
    public Address saveAddress(Address address) {
        if (address.getAddressId() != null && addressRepository.existsById(address.getAddressId())) {
            throw new OperationException();
        }
        return addressRepository.save(address);
    }

}
