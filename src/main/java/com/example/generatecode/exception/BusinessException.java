package com.example.generatecode.exception;


public class BusinessException extends BaseException {

    private ExceptionDefin exceptionDefin;

    public BusinessException(ExceptionDefin exceptionDefin){
        super(exceptionDefin.getCode(), exceptionDefin.getMsg());
        this.exceptionDefin = exceptionDefin;
    }

    public BusinessException(int code, String msg){
        super(code, msg);
    }

    public ExceptionDefin getExceptionDefin() {
        return exceptionDefin;
    }
}
