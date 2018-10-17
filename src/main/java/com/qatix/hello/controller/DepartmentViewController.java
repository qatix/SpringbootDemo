package com.qatix.hello.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qatix.hello.entity.Supplier;
import com.qatix.hello.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depart")
@Controller
public class DepartmentViewController {

    @GetMapping("/list")
    public String list(Model model) {
        return "depart/list";
    }
}
