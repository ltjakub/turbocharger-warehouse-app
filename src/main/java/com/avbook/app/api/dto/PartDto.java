package com.avbook.app.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class PartDto {
    private UUID id;
    private Integer quantity;
}
