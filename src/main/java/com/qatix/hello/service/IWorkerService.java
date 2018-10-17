package com.qatix.hello.service;

import com.baomidou.mybatisplus.service.IService;
import com.qatix.hello.entity.Worker;

import java.util.List;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
public interface IWorkerService extends IService<Worker> {

    List<Worker> selectListByNameAndSalary();
}
