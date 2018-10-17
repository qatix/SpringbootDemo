package com.qatix.hello.service;

import com.baomidou.mybatisplus.service.IService;
import com.qatix.hello.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {

    List<Product> selectListBySQL();
    Product selectByIdWithCategory(Integer id);

}
