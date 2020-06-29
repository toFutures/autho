package com.lsdd.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * 响应码枚举类
 */
//@Getter  可以使用让其自动设置Getter方法
public enum ResultCode {
    SUCCESS(1000, "操作成功"),
    FAILED(1001, "响应失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
