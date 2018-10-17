package com.qatix.hello.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.service.ICategoryService;
import com.qatix.hello.service.IProductService;
import com.qatix.hello.dao.ProductMapper;
import com.qatix.hello.entity.Category;
import com.qatix.hello.entity.Product;
import com.qatix.hello.service.ICategoryService;
import com.qatix.hello.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Override
    public List<Product> selectListBySQL(){
        return baseMapper.selectListBySQL();
    }

    @Override
    public Product selectByIdWithCategory(Integer id) {
        Product product = this.selectById(id);
        Category category = this.categoryService.selectById(product.getCategoryId());
        if(category != null){
            product.setCategory(category);
        }
        return product;
    }
}
