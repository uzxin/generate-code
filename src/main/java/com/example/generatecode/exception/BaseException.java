package com.example.generatecode.exception;

public class BaseException extends RuntimeException {
    private int code;

    private String msg;

    public BaseException(int code, String msg) {
        super(msg);
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
