package com.gabriel.finalexercise.Services;

public class ExceptionHandler extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExceptionHandler(String msg) {
        super(msg);
    }
}
