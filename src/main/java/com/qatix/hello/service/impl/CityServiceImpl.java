package com.qatix.hello.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.service.ICityService;
import com.qatix.hello.dao.CityMapper;
import com.qatix.hello.entity.City;
import com.qatix.hello.service.ICityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper,City> implements ICityService {

    @Override
    public Integer deleteAll() {
        return baseMapper.deleteAll();
    }
}
