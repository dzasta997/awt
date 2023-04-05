package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.UserInfoDTO;
import com.pwr.awt.librarysystem.entity.UserInfo;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper extends ApplicationMapper<UserInfo, UserInfoDTO> {
    private final AddressMapper addressMapper;

    @Autowired
    public UserInfoMapper(final AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public UserInfo toEntity(final UserInfoDTO userInfoDTO) {
        if(userInfoDTO==null) {
            return null;
        }
        return new UserInfo()
                .setUserInfoId(userInfoDTO.getUserInfoId())
                .setFirstName(userInfoDTO.getFirstName())
                .setLastName(userInfoDTO.getLastName())
                .setEmail(userInfoDTO.getEmail())
                .setPhoneNumber(userInfoDTO.getPhoneNumber())
                .setAddress(addressMapper.toEntity(userInfoDTO.getAddress()));
    }

    @Override
    public UserInfoDTO toDto(final UserInfo userInfo) {
        if(userInfo==null) {
            return null;
        }
        return new UserInfoDTO()
                .setUserInfoId(userInfo.getUserInfoId())
                .setFirstName(userInfo.getFirstName())
                .setLastName(userInfo.getLastName())
                .setEmail(userInfo.getEmail())
                .setPhoneNumber(userInfo.getPhoneNumber())
                .setAddress(addressMapper.toDto(userInfo.getAddress()));
    }
}
