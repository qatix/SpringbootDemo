package com.qatix.hello.dao;

import com.qatix.hello.entity.City;
import com.qatix.hello.entity.City;
import org.apache.ibatis.annotations.Mapper;

public interface CityMapper extends SuperMapper<City> {
//    City selectCityById(int city_id);

//    Integer insertCity(City city);
//
//    Integer updateCity(City city);

//    Integer deleteCityById(Integer id);
//
//    List<City> findAll();

    Integer deleteAll();
}