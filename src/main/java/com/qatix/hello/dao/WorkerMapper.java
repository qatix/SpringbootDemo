package com.qatix.hello.dao;

import com.qatix.hello.entity.Worker;
import com.qatix.hello.entity.Worker;

import java.util.List;

public interface WorkerMapper extends SuperMapper<Worker> {

    List<Worker> selectListByNameAndSalary();
}