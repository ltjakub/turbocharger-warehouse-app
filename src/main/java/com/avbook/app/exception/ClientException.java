package com.avbook.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientException extends RuntimeException {
    private final ErrorMessage errorMessage;
}
