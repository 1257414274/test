package com.myj.shopping.exception;

import com.myj.shopping.model.base.BaseResponse;
import com.myj.shopping.model.base.ErrorMessage;
import lombok.Getter;

import java.io.Serializable;

/**
 * 异常类
 */
@Getter
public class BaseException extends RuntimeException implements Serializable {
    private Integer code;
    private String message;
    public BaseException() {
        super();
    }
    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public static BaseException error(ErrorMessage message) {
        return new BaseException(message.getCode(), message.getMessage());
    }
    public static BaseException error(BaseResponse baseResponse) {
        return new BaseException(baseResponse.getCode(), baseResponse.getMessage());
    }
    public void setMessage(String defaultMessage) {
        this.message = defaultMessage;
    }
}