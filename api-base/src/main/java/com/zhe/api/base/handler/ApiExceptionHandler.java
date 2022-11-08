package com.zhe.api.base.handler;

import com.zhe.api.base.bean.BaseResponse;
import com.zhe.api.base.constant.RespCodeEnum;
import com.zhe.api.base.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResponse<?> processBusinessException(BusinessException e) {
        return new BaseResponse<>(e.getRespCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse<?> processException(Exception e) {
        return new BaseResponse<>(RespCodeEnum.SYSTEM_ERROR);
    }

}
