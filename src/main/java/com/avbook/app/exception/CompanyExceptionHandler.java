package com.avbook.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyExceptionHandler {

    @ExceptionHandler(CompanyException.class)
    protected ResponseEntity<Object> handleCompanyException(CompanyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorMessage());
    }

}