package com.zhe.api.base.exception;

import com.zhe.api.base.constant.RespCodeEnum;

public class BusinessException extends RuntimeException{

    private RespCodeEnum respCode;

    public BusinessException(RespCodeEnum respCode) {
        this.respCode = respCode;
    }

    public RespCodeEnum getRespCode() {
        return respCode;
    }

    public void setRespCode(RespCodeEnum respCode) {
        this.respCode = respCode;
    }
}
