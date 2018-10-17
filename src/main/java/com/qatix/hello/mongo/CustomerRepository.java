package com.qatix.hello.mongo;

import com.qatix.hello.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByOpenid(String openid);

    /**
     * 获取的是nickname满足nickname后面的记录，而不是后缀匹配
     *
     * @param nickname
     * @return
     */
    public List<Customer> findByNicknameAfter(String nickname);

    //如果返回结果不只一个，必须用List
    public List<Customer> findBySex(Integer sex);

}
