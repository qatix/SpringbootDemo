package com.qatix.hello.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wxfan")
public class Customer {

    @Id
    public String id;
    public String openid;
    public String nickname;
    public String city;
    public Integer sex;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Customer(String openid, String nickname, String city, Integer sex) {
        this.openid = openid;
        this.nickname = nickname;
        this.city = city;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s,openid=%s,nickname=%s,city=%s,sex=%d]",
                id, openid, nickname, city, sex);
    }
}
