package com.intuit.peerpay_api.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {

    private String message;
    private List<String> errors;

    public ApiError(String message, List<String> errors) {
        super();
        this.message = message;
        this.errors = errors;
    }

    public ApiError(String message, String error) {
        super();
        this.message = message;
        errors = Arrays.asList(error);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    public void setError(final String error) {
        errors = Arrays.asList(error);
    }

}
