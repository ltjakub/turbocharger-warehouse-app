package com.avbook.app.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class ClientDto {
    private UUID id;
    private String email;
    private AddressDto address;
    private UUID companyId;
    private List<TurbochargerDto> turbochargers;
}
