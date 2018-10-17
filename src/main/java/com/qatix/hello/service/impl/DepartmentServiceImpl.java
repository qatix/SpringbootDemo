package com.qatix.hello.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.service.IDepartmentService;
import com.qatix.hello.dao.DepartmentMapper;
import com.qatix.hello.entity.Department;
import com.qatix.hello.service.IDepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements IDepartmentService {

}
