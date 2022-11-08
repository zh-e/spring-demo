package com.zhe.api.base.constant;

public enum RespCodeEnum {

    /**
     *
     */

    SUCCESS(0, ""),

    SYSTEM_ERROR(1, "系统异常"),

    ;

    RespCodeEnum(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final long code;

    private final String msg;

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
