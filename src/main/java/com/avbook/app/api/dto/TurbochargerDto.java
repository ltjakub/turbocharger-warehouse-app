package com.avbook.app.api.dto;

import com.avbook.app.entity.TurbochargerStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class TurbochargerDto {
    private UUID id;
    private UUID companyId;
    private String serialNo;
    private TurbochargerStatus status;
    private String brand;
    private String model;
    private String engineType;
    private Integer volume;
    private Integer power;
    private LocalDate producedFrom;
    private LocalDate producedTo;
    private String position;
    private UUID clientId;
}
