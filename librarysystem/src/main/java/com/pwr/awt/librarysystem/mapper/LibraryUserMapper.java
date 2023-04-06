package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.LibraryUserDTO;
import com.pwr.awt.librarysystem.entity.LibraryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryUserMapper extends ApplicationMapper<LibraryUser, LibraryUserDTO> {
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public LibraryUserMapper(final UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public LibraryUser toEntity(final LibraryUserDTO libraryUserDTO) {
        if(libraryUserDTO==null) {
            return null;
        }
        return new LibraryUser()
                .setUserId(libraryUserDTO.getUserId())
                .setUsername(libraryUserDTO.getUsername())
                .setPassword(libraryUserDTO.getPassword())
                .setRole(libraryUserDTO.getRole())
                .setUserInfo(userInfoMapper.toEntity(libraryUserDTO.getUserInfo()));
    }

    @Override
    public LibraryUserDTO toDto(final LibraryUser libraryUser) {
        if(libraryUser==null) {
            return null;
        }
        return new LibraryUserDTO()
                .setUserId(libraryUser.getUserId())
                .setUsername(libraryUser.getUsername())
                .setPassword(libraryUser.getPassword())
                .setRole(libraryUser.getRole())
                .setUserInfo(userInfoMapper.toDto(libraryUser.getUserInfo()));
    }
}
