package com.avbook.app.api.dto;

import com.avbook.app.entity.TurbochargerStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class TurbochargerDto {
    private UUID id;
    private UUID companyId;
    private String serialNo;
    private TurbochargerStatus status;
    private String position;
    private String clientEmail;
}
