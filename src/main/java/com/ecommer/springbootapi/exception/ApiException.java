package com.ecommer.springbootapi.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public ApiException(String message, String message1, HttpStatus status) {
        super(message);
        this.message = message1;
        this.status = status;
    }

    public ApiException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
