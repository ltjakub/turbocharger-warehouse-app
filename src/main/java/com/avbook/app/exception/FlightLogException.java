package com.avbook.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlightLogException extends RuntimeException {
    private final ErrorMessage errorMessage;
}
