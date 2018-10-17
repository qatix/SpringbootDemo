package com.qatix.hello.service;

import com.baomidou.mybatisplus.service.IService;
import com.qatix.hello.core.exception.CommonException;
import com.qatix.hello.core.RetEntity;
import com.qatix.hello.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
public interface IUserService extends IService<User> {

    RetEntity<User> register(String ip,User user) throws CommonException, NoSuchAlgorithmException, UnsupportedEncodingException;
    RetEntity<User> login(String ip, @RequestBody User user) throws CommonException, NoSuchAlgorithmException, UnsupportedEncodingException;
    User insertByEncryption(User user) throws NoSuchAlgorithmException,UnsupportedEncodingException;
    RetEntity<String> isExistMac(String ip) throws CommonException;

}
