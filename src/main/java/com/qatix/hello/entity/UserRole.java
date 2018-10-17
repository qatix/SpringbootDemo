package com.qatix.hello.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_role")
public class UserRole extends Model<UserRole> {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return String.format("%d-%d",this.userId,this.roleId);
    }
}