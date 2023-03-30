package com.pwr.awt.librarysystem.dto;

import com.pwr.awt.librarysystem.entity.UserInfo;


public class LibraryUserDTO {
    private Long userId;
    private String username;
    private String password;
    //TODO:    Will be changed to enum, now just a draft
    private String role;
    private UserInfoDTO userInfo;

    public LibraryUserDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public LibraryUserDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LibraryUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LibraryUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public LibraryUserDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public LibraryUserDTO setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
        return this;
    }
}
