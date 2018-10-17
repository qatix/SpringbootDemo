package com.qatix.hello.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.dao.SupplierMapper;
import com.qatix.hello.entity.Supplier;
import com.qatix.hello.service.ISupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {
}
