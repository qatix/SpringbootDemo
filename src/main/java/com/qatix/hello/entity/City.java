package com.qatix.hello.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("city")
public class City extends SuperEntity<City> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String state;

    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getState() + "," + getCountry();
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}