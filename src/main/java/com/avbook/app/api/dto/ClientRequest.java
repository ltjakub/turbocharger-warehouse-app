package com.avbook.app.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientRequest {
    private String email;
    private UUID companyId;

    private String street;
    private String city;
    private String state;
    private String zip;
}
