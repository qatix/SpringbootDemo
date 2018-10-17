package com.qatix.hello.controller;

import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Customer;
import com.qatix.hello.mongo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/init")
    public String testGet() {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("C11111", "Alice", "Chengdu", 0));
        repository.save(new Customer("C22222", "Bob", "Beijing", 1));
        repository.save(new Customer("C33333", "Jenise", "Davao", 0));
        repository.save(new Customer("C44444", "Logan", "Neijiang", 1));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        return "initial done";
    }

    @RequestMapping("/list")
    public Result getAll() {
        return ResultGenerator.genSuccessResult(repository.findAll());
    }

    @RequestMapping("/findbysex")
    public Result findBySex(@RequestParam Integer sex) {
        return ResultGenerator.genSuccessResult(repository.findBySex(sex));
    }

    @RequestMapping("/findbyname")
    public Result findByNameAfter(@RequestParam String name) {
        return ResultGenerator.genSuccessResult(repository.findByNicknameAfter(name));
    }

    @RequestMapping("/findbyopenid")
    public Result findByOpenid(@RequestParam String openid) {
        return ResultGenerator.genSuccessResult(repository.findByOpenid(openid));
    }
}
