package com.avbook.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND);

    private final HttpStatus status;
}
