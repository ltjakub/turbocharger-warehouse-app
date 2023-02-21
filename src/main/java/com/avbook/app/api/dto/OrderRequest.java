package com.avbook.app.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class OrderRequest {
    private UUID turbochargerId;
    private List<PartDto> parts;
}
