package com.qatix.hello.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.core.CommonConstant;
import com.qatix.hello.core.CommonUtil;
import com.qatix.hello.core.Ethernet;
import com.qatix.hello.core.*;
import com.qatix.hello.core.exception.CommonException;
import com.qatix.hello.dao.UserMapper;
import com.qatix.hello.entity.User;
import com.qatix.hello.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private Ethernet ethernet;

    @Override
    public RetEntity<User> register(String ip, User user) throws CommonException, NoSuchAlgorithmException, UnsupportedEncodingException {
        RetEntity<User> retEntity = new RetEntity<User>();
        user.setMacaddress(ethernet.getMAC(ip));
        EntityWrapper<User> ewUser = new EntityWrapper<User>();
        ewUser.eq("username", user.getUsername());
        List<User> usersWithUsername = this.selectList(ewUser);
        if (usersWithUsername.size() > 0) {
            retEntity.setCode(CommonConstant.RESULT_CODE_CONFLICT);
            retEntity.setMessage("该用户名已存在");
            return retEntity;
        }
        User userInsert = this.insertByEncryption(user);
        if (userInsert != null) {
//            CommonUtil.cache.put(userInsert.getId(), new HashMap<>());
//            MythreadLocal.set("session", CommonUtil.cache.get(userInsert.getId()));
//            CommonUtil.set("user", userInsert);
            retEntity.setData(userInsert);
            retEntity.setCode(CommonConstant.RESULT_CODE_OK);
            retEntity.setMessage(MsgConstant.RET_JUDGE_REGISTER_SUCCESS);
        } else {
            retEntity.setCode(CommonConstant.RESULT_CODE_EXPECTATION_FAILED);
            retEntity.setMessage(MsgConstant.RET_JUDGE_REGISTER_FAILURE);
        }
        return retEntity;
    }

    @Override
    public RetEntity<User> login(String ip, User user) throws CommonException, NoSuchAlgorithmException, UnsupportedEncodingException {
        RetEntity<User> retEntity = new RetEntity<User>();

        user.setMacaddress(ethernet.getMAC(ip));

        EntityWrapper<User> ewUsername = new EntityWrapper<User>();
        ewUsername.eq("username", user.getUsername());

        List<User> listUser = this.selectList(ewUsername);
        if (listUser.size() == 0) {
            throw new CommonException(CommonConstant.RESULT_CODE_UNAUTHORIZED, MsgConstant.RET_JUDGE_ID_NOT_EXIST);
        }

        User userDb = listUser.get(0);
        boolean isPasswordValid = MD5Encoder.validPassword(user.getPassword(), userDb.getPassword());
        if (isPasswordValid) {
            userDb.setPassword(null);//clear password
            CommonUtil.cache.put(userDb.getToken(), new HashMap<>());
            System.out.println("set session");
            System.out.println("userdb:"+userDb.toString());
            MythreadLocal.set("session", CommonUtil.cache.get(userDb.getToken()));
            CommonUtil.set("user", userDb);
            System.out.println("after set:"+CommonUtil.get("user").toString());
            retEntity.setCode(CommonConstant.RESULT_CODE_OK);
            retEntity.setMessage(MsgConstant.RET_JUDGE_LOGIN_SUCCESS);
            retEntity.setData(userDb);
        } else {
            retEntity.setCode(CommonConstant.RESULT_CODE_UNAUTHORIZED);
            retEntity.setMessage(MsgConstant.RET_JUDGE_PASSWORD_NOT_RIGHT);
        }
        return retEntity;
    }

    @Override
    public User insertByEncryption(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        user.setPassword(MD5Encoder.getEncryptedPwd(user.getPassword()));
        user.setToken(CommonUtil.createRandom(false,64));
        this.insert(user);
        return user;
    }

    @Override
    public RetEntity<String> isExistMac(String ip) throws CommonException {
        String mac = ethernet.getMAC(ip);
        RetEntity<String> retEntity = new RetEntity<String>();
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.eq("macaddress", mac);
        List<User> list = this.selectList(ew);
        if (list.size() > 0) {
            retEntity.setCode(CommonConstant.RESULT_CODE_OK);
            retEntity.setMessage(list.get(0).getUsername());
            retEntity.setData("true");
        } else {
            retEntity.setCode(CommonConstant.RESULT_CODE_OK);
            retEntity.setMessage(MsgConstant.RET_JUDGE_MACADDRESS_ISNEW);
            retEntity.setData("false");
        }
        return retEntity;
    }
}
