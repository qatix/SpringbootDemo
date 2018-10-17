package com.qatix.hello.service;

import com.baomidou.mybatisplus.service.IService;
import com.qatix.hello.entity.City;

public interface ICityService extends IService<City> {
    Integer deleteAll();
}
