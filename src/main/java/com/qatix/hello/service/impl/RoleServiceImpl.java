package com.qatix.hello.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qatix.hello.dao.RoleMapper;
import com.qatix.hello.entity.Role;
import com.qatix.hello.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by CodeGenerator on 2018/04/02.
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService {

}
