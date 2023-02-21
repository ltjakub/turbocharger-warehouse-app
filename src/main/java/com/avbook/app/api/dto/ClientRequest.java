package com.avbook.app.api.dto;

import com.avbook.app.entity.Address;
import com.avbook.app.entity.Company;
import com.avbook.app.entity.Turbocharger;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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
