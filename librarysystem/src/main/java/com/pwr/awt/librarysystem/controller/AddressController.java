package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.mapper.AddressMapper;
import com.pwr.awt.librarysystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
