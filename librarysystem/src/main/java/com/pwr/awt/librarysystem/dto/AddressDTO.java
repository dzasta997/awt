package com.pwr.awt.librarysystem.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;


public class AddressDTO {
    private Long addressId;
    private String street;
    private String number;
    private String city;
    private String zipcode;

    public AddressDTO() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public AddressDTO setAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDTO setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public AddressDTO setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public AddressDTO setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }
}
