package com.pwr.awt.librarysystem.entity;

import jakarta.persistence.*;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userInfoId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @OneToOne
    private Address address;

    public UserInfo() {
    }

    public Long getUserInfoId() {
        return userInfoId;
    }

    public UserInfo setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserInfo setAddress(Address address) {
        this.address = address;
        return this;
    }
}
