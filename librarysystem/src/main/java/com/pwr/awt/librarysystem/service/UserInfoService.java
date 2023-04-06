package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.UserInfo;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoService(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    public UserInfo findByUserInfoId(long id) {
        return userInfoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!userInfoRepository.existsById(id)){
            throw new OperationException();
        }
        userInfoRepository.deleteById(id);
    }
    public UserInfo saveUserInfo(UserInfo userInfo) {
        if (userInfo.getUserInfoId() != null && userInfoRepository.existsById(userInfo.getUserInfoId())) {
            throw new OperationException();
        }
        return userInfoRepository.save(userInfo);
    }

}
