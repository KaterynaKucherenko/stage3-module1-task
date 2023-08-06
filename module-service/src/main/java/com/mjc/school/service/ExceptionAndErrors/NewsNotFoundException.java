package com.mjc.school.service.ExceptionAndErrors;

public class NewsNotFoundException extends RuntimeException {
    public  NewsNotFoundException(String message){
        super(message);
    }
}
