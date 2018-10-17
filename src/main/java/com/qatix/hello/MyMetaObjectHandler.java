package com.qatix.hello;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

/**
 * 注入公共字段自动填充,任选注入方式即可
 */
//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    protected final static Logger logger = LoggerFactory.getLogger(Application.class);

    public void insertFill(MetaObject metaObject) {
        logger.info("DB insert fill:" + metaObject.toString());

        Object createTime = getFieldValByName("createTime", metaObject);
        Object createUser = getFieldValByName("createUser", metaObject);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        //String userCd = new CommonUtil().getCurrentUser().getId();
        String userCd = "12345678901234567890123456789012";
        if (null == createTime) {
            logger.info("set create time");
            setFieldValByName("createTime", ts.toString(), metaObject);
            setFieldValByName("updateTime", ts.toString(), metaObject);
        }
        if (null == createUser) {
            logger.info("set create user");
            setFieldValByName("createUser", userCd, metaObject);
            setFieldValByName("updateUser", userCd, metaObject);
        }

        logger.info("create time:" + createTime);
        logger.info("create user:" + createUser);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        logger.info("DB update fill:" + metaObject.toString());

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        //String userid = new CommonUtil().getCurrentUser().getId();
        String userid = "12345678901234567890123456789012";
        Object createTime = getFieldValByName("createTime", metaObject);
        Object createUser = getFieldValByName("createUser", metaObject);
        logger.info("create time:" + createTime);
        logger.info("create user:" + createUser);
        if (createTime == null) {
            logger.info("set create time");
            setFieldValByName("createTime", ts.toString(), metaObject);
        }
        if (createUser == null) {
            logger.info("set create user");
            setFieldValByName("createUser", userid, metaObject);
        }

        setFieldValByName("updateTime", ts.toString(), metaObject);
        setFieldValByName("updateUser", userid, metaObject);

        //注入进去了但是没有生效？
    }
}
