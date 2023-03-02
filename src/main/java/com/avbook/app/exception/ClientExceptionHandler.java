package com.avbook.app.exception;

import com.avbook.app.entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(ClientException.class)
    protected ResponseEntity<Object> handleCompanyException(ClientException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorMessage());
    }

}