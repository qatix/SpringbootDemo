package com.qatix.hello.service.impl;

import com.qatix.hello.service.ICategoryService;
import com.qatix.hello.dao.CategoryMapper;
import com.qatix.hello.entity.Category;
import com.qatix.hello.service.ICategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements ICategoryService {

}
