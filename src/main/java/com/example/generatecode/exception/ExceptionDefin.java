package com.example.generatecode.exception;

public enum ExceptionDefin {

    SERVER_ERROR(500, "服务器发生错误"),
    ;
    private int code;
    private String msg;

    ExceptionDefin(int code, String msg) {
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
