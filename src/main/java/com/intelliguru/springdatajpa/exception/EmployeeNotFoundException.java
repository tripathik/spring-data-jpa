package com.intelliguru.springdatajpa.exception;

public class EmployeeNotFoundException extends  Exception{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
