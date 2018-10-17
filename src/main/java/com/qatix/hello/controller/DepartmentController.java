package com.qatix.hello.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qatix.hello.core.Result;
import com.qatix.hello.core.ResultCode;
import com.qatix.hello.core.ResultGenerator;
import com.qatix.hello.entity.Department;
import com.qatix.hello.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/department")
@RestController
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/add")
    public Result add(Department department) {
        departmentService.insert(department);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/get")
    public Result get(@RequestParam(value = "id") Integer id) {
        System.out.println("get department:" + id);
        Department department = departmentService.selectById(id);
        if (department != null) {
            return ResultGenerator.genSuccessResult(department);
        } else {
            return ResultGenerator.genFailResult(ResultCode.NOT_FOUND, "not_found");
        }
    }

    @PostMapping("/delete")
    public Result delete(Department department) {
        System.out.println("delete department:" + department.toString());
        departmentService.deleteById(department);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/update")
    public Result update(@RequestParam Department department) {
        departmentService.updateById(department);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        System.out.println("list department");
        List<Department> list = departmentService.selectList(new EntityWrapper<Department>());
        return ResultGenerator.genSuccessResult(list);
    }
}
