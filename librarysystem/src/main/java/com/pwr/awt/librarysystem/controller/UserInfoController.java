package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.UserInfoDTO;
import com.pwr.awt.librarysystem.entity.UserInfo;
import com.pwr.awt.librarysystem.mapper.UserInfoMapper;
import com.pwr.awt.librarysystem.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("userinfo")
public class UserInfoController {
    private final UserInfoMapper userInfoMapper;
    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoMapper userInfoMapper, UserInfoService userInfoService) {
        this.userInfoMapper = userInfoMapper;
        this.userInfoService = userInfoService;
    }

    @GetMapping
    public ResponseEntity<List<UserInfoDTO>> getAllUserInfo() {
        List<UserInfo> userInfo = userInfoService.findAll();
        return new ResponseEntity<>(userInfoMapper.toDto(userInfo), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable long id) {
        UserInfo userInfo = userInfoService.findByUserInfoId(id);
        return new ResponseEntity<>(userInfoMapper.toDto(userInfo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserInfoDTO> postUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        UserInfo userInfoSaved = userInfoService.saveUserInfo(userInfoMapper.toEntity(userInfoDTO));
        return new ResponseEntity<>(userInfoMapper.toDto(userInfoSaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserInfo(@PathVariable long id) {
        userInfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
