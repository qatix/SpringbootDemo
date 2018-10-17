package com.qatix.hello.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Category;
import com.qatix.hello.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/add")
    public Result add(Category category) {
        System.out.println("add category::");
        System.out.println(category.toString());
        categoryService.insert(category);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        categoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Category category) {
        System.out.println("update category:");
        System.out.println(category.toString());
        categoryService.updateById(category);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Category category = categoryService.selectById(id);
        return ResultGenerator.genSuccessResult(category);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        List<Category> list = categoryService.selectList(new EntityWrapper<>());
        return ResultGenerator.genSuccessResult(list);
    }
}
