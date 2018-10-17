package com.qatix.hello.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultCode;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Product;
import com.qatix.hello.service.IProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public Result addProduct(Product product) {
        System.out.println("add product::");
        System.out.println(product.toString());
        productService.insert(product);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "getProduct", nickname = "getProduct-nickname")
    @RequestMapping(method = RequestMethod.GET, path = "/get", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "product id", required = true, dataType = "int", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Product.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure"),
            @ApiResponse(code = 503, message = "Server ERR")})
    public Result getProduct(@RequestParam(value = "id") Integer id) {
        System.out.println("get product:" + id);
        Product product = productService.selectById(id);
        if (product != null) {
            return ResultGenerator.genSuccessResult(product);
        } else {
            return ResultGenerator.genFailResult(ResultCode.NOT_FOUND, "not_found");
        }
    }

    @GetMapping("/get2/{id}")
    public Result getProduct2(@PathVariable Integer id) {
        System.out.println("get product:" + id);
        Product product = productService.selectByIdWithCategory(id);
        if (product != null) {
            return ResultGenerator.genSuccessResult(product);
        } else {
            return ResultGenerator.genFailResult(ResultCode.NOT_FOUND, "not_found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    public Result deleteProduct(@RequestParam Integer id) {
        System.out.println("delete product:" + id);
        productService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list", produces = "application/json")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        System.out.println("list product");
        List<Product> list = productService.selectList(new EntityWrapper<Product>());
        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list2")
    public Result list2(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        System.out.println("list2 product");
        List<Product> list = productService.selectListBySQL();
        return ResultGenerator.genSuccessResult(list);
    }

}
