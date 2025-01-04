package com.intelliguru.springdatajpa.exception;

public class SqlDbException extends Exception{

    public SqlDbException(String message){
        super(message);
    }

    public SqlDbException(String message, Throwable cause){
        super(message, cause);
    }
}
