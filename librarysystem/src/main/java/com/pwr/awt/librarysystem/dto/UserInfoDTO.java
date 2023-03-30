package com.pwr.awt.librarysystem.dto;


import com.pwr.awt.librarysystem.entity.Address;

public class UserInfoDTO {
    private Long userInfoId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressDTO address;

    public UserInfoDTO() {
    }

    public Long getUserInfoId() {
        return userInfoId;
    }

    public UserInfoDTO setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserInfoDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserInfoDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfoDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserInfoDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public UserInfoDTO setAddress(AddressDTO address) {
        this.address = address;
        return this;
    }
}
