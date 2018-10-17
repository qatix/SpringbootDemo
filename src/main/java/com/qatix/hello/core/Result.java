package com.qatix.hello.core;

import com.alibaba.fastjson.JSON;

public class Result {
    private int code;
    private String messgae;
    private Object data;

    public Result setCode(ResultCode resultCode){
        this.code = resultCode.code();
        return this;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return messgae;
    }

    public Result setMessage(String message){
        this.messgae = message;
        return this;
    }

    public Object getData(){
        return data;
    }

    public Result setData(Object data){
        this.data = data;
        return this;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
