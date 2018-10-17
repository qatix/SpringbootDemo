package com.qatix.hello.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultCode;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.City;
import com.qatix.hello.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/city")
@RestController
public class CityController {

    @Autowired
    private ICityService cityService;

    @PostMapping("/add")
    public Result addCity(City city){
        cityService.insert(city);
        return ResultGenerator.genSuccessResult(city);
    }

    @RequestMapping("/get")
    public Result getCity(@RequestParam(value = "id") Integer id){
        System.out.println("get city2:"+id);
        City city = cityService.selectById(id);
        if(city != null) {
            return ResultGenerator.genSuccessResult(city);
        }else{
            return ResultGenerator.genFailResult(ResultCode.NOT_FOUND,"not_found");
        }
    }

    @RequestMapping("/get2/{id}")
    public Result getCityWithPath(@PathVariable Integer id){
        System.out.println("get2 city:"+id);
        City city = cityService.selectById(id);
        if(city != null) {
            return ResultGenerator.genSuccessResult(city);
        }else{
            return ResultGenerator.genFailResult(ResultCode.NOT_FOUND,"not_found");
        }
    }

    @RequestMapping("/delete")
    public Result deleteCity(@RequestParam Integer id){
        System.out.println("delete city:"+id);
        cityService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/delete_all")
    public Result deleteCityAll(){
        System.out.println("delete city all");
        cityService.deleteAll();
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "0")Integer page,@RequestParam(defaultValue = "0")Integer size){
        System.out.println("list city");
        List<City> list = cityService.selectList(new EntityWrapper<City>());
        return ResultGenerator.genSuccessResult(list);
    }

}
