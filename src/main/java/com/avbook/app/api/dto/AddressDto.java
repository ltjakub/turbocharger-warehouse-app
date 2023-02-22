package com.avbook.app.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressDto {
    private UUID id;
    private String street;
    private String city;
    private String state;
    private String zip;
}
