package com.mjc.school.service.ExceptionAndErrors;

public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
