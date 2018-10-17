package com.qatix.hello.controller;

import com.qatix.hello.core.CommonConstant;
import com.qatix.hello.core.CommonUtil;
import com.qatix.hello.core.CommonConstant;
import com.qatix.hello.core.exception.CommonException;
import com.qatix.hello.core.CommonUtil;
import com.qatix.hello.core.RetEntity;
import com.qatix.hello.entity.User;
import com.qatix.hello.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
* Created by CodeGenerator on 2018/04/02.
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("user register")
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public RetEntity<User> register(User user, HttpServletRequest request) throws CommonException, NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("user:"+user.toString());
        String ip;
        if ("0:0:0:0:0:0:0:1".equals(request.getRemoteAddr() )) {
            ip = "127.0.0.1";
        } else {
            ip = request.getRemoteAddr();
        }
        RetEntity<User> retEntity = userService.register(ip,user);
        return retEntity;
    }

    @ApiOperation("user login")
    @PostMapping("/login")
    public RetEntity<User> login(User user,HttpServletRequest request) throws CommonException, NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("user:"+user.toString());
        String ip;
        if ("0:0:0:0:0:0:0:1".equals(request.getRemoteAddr() )) {
            ip = "127.0.0.1";
        } else {
            ip = request.getRemoteAddr();
        }
        RetEntity<User> retEntity = userService.login(ip,user);
        return retEntity;
    }

    @ApiOperation("check mac address")
    @GetMapping("/isExistMac")
    public RetEntity<String> checkMac(HttpServletRequest request) throws CommonException {
        String ip;
        if ("0:0:0:0:0:0:0:1".equals(request.getRemoteAddr() )) {
            ip = "127.0.0.1";
        } else {
            ip = request.getRemoteAddr();
        }
        RetEntity<String> retEntity = userService.isExistMac(ip);
        return retEntity;
    }

    @GetMapping("/info")
    public RetEntity<User> getInfo() {
        RetEntity<User> retEntity = new RetEntity<>();

        Object loggedUser = CommonUtil.get("user");
        System.out.println("logged user:" + loggedUser);
        if(loggedUser == null){
            retEntity.setCode(CommonConstant.RESULT_CODE_UNAUTHORIZED);
            retEntity.setMessage("not_loggin");
        }else {
            retEntity.setCode(CommonConstant.RESULT_CODE_OK);
            retEntity.setMessage("SUCCESS");
            retEntity.setData((User) loggedUser);
        }
        return retEntity;
    }
}
