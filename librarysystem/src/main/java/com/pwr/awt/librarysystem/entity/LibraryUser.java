package com.pwr.awt.librarysystem.entity;

import jakarta.persistence.*;

@Entity
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String username;
    private String password;
    //TODO:    Will be changed to enum, now just a draft
    private String role;
    @OneToOne
    @JoinColumn(name="user_info_id")
    private UserInfo userInfo;

    public LibraryUser() {
    }

    public Long getUserId() {
        return userId;
    }

    public LibraryUser setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LibraryUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LibraryUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public LibraryUser setRole(String role) {
        this.role = role;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public LibraryUser setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }
}
