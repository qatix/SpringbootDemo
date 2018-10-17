package com.qatix.hello.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

public abstract class SuperEntity<T extends Model> extends Model<T>  {

    @TableField(value = "update_time",update = "NOW()")
    public String updateTime;

    @TableField(value = "create_time")
    public String createTime;

    @TableField(value = "update_user")
    public String updateUser;

    @TableField(value = "create_user")
    public String createUser;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
