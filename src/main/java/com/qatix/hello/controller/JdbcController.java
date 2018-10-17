package com.qatix.hello.controller;

import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/products1")
    public Result getProducts(){

        List<Product> list = jdbcTemplate.query("select id,name,model,no,price from product limit 100", new Object[]{},
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int i) throws SQLException {
                        Product p = new Product();
                        p.setId(rs.getLong("id"));
                        p.setName(rs.getString("name"));
                        p.setModel(rs.getNString("model"));
                        p.setNo(rs.getString("no"));
                        p.setPrice(rs.getBigDecimal("price"));
                        return p;
                    }
                });
        return ResultGenerator.genSuccessResult(list);
    }
}
