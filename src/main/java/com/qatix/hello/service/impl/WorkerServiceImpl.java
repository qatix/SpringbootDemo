package com.qatix.hello.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.dao.WorkerMapper;
import com.qatix.hello.entity.Worker;
import com.qatix.hello.service.IWorkerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper,Worker> implements IWorkerService {

    @Override
    public List<Worker> selectListByNameAndSalary() {
        return baseMapper.selectListByNameAndSalary();
    }
}
