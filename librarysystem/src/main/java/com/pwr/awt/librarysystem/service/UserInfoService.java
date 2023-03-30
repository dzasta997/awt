package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoService(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
}
