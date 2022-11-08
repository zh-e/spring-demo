package com.zhe.api.base.bean;


import com.zhe.api.base.constant.RespCodeEnum;

public class BaseResponse<T> {

    private long code;

    private String msg;

    private T data;

    public BaseResponse() {

    }

    public BaseResponse(RespCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    public BaseResponse(RespCodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
        this.data = data;
    }

    public BaseResponse(long code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
