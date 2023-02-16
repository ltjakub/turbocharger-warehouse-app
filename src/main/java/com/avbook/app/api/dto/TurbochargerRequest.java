package com.avbook.app.api.dto;

import com.avbook.app.entity.Company;
import com.avbook.app.entity.TurbochargerStatus;
import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.UUID;

public class TurbochargerRequest {
    private Company company;
    private String serialNo;
    private TurbochargerStatus status;
    private String brand;
    private String model;
    private String engineType;
    private Integer volume;
    private Integer power;
    private LocalDate producedFrom;
    private LocalDate producedTo;
}
