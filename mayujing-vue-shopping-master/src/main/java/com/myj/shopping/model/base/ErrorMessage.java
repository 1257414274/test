package com.myj.shopping.model.base;

public enum ErrorMessage {

    //错误码
    SUCCESS(0,"成功"),//成功
    FAILED(1,"失败"),//失败
    PARAM_ERROR(-10000, "参数错误"),
    //登录异常
    SYSTEM_ERROR(-9999,"未知异常，请稍后重试"),
    LOGIN_NO_USER(-9998,"登录失败，用户名不存在"),//登录-无用户
    LOGIN_PASS_ERROR(-9997,"登录失败，用户或密码错误"),//登录-密码错误
    LOGIN_NO(-9996,"用户未登录！"),//用户未登录
    PRODUCTTYPE_DEL(-9995,"商品类型已被删除"),
    ACTIVITY_DEL(-994,"活动已删除");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
