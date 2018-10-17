package com.qatix.hello.dao;

import com.baomidou.mybatisplus.annotations.SqlParser;
import com.qatix.hello.entity.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends SuperMapper<Product> {

    @SqlParser(filter = true)
    @Select("select id as product_id,name,model,price from product")
    List<Product> selectListBySQL();
}
