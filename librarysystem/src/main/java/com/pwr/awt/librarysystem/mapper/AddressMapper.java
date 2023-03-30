package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.AddressDTO;
import com.pwr.awt.librarysystem.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper extends ApplicationMapper<Address, AddressDTO> {

    @Override
    public Address toEntity(final AddressDTO addressDTO) {
        if (addressDTO == null) {

            return null;
        }
        return new Address()
                .setAddressId(addressDTO.getAddressId())
                .setCity(addressDTO.getCity())
                .setStreet(addressDTO.getStreet())
                .setNumber(addressDTO.getNumber())
                .setZipcode(addressDTO.getZipcode());
    }

    @Override
    public AddressDTO toDto(final Address address) {
        if (address == null) {
            return null;
        }
        return new AddressDTO()
                .setAddressId(address.getAddressId())
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setNumber(address.getNumber())
                .setZipcode(address.getZipcode());
    }
}
