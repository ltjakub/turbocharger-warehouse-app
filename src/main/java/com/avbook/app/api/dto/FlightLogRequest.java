package com.avbook.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightLogRequest {

    private UUID id;
    private String acRegistration;
    private String instructor;
    private String from;
    private String to;
    private LocalDateTime takeoff;
    private LocalDateTime landing;
    private Integer landingQuantity;

}
