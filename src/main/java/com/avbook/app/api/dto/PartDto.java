package com.avbook.app.api.dto;

import com.avbook.app.entity.Company;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class PartDto {
    private UUID id;
    private Integer quantity;
}
