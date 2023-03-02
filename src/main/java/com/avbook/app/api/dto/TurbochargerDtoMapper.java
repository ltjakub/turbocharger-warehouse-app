package com.avbook.app.api.dto;

import com.avbook.app.entity.Turbocharger;

public class TurbochargerDtoMapper {
    public static TurbochargerDto map(Turbocharger turbocharger) {
        TurbochargerDto request = new TurbochargerDto();
        request.setId(turbocharger.getId());
        request.setCompanyId(turbocharger.getCompany().getId());
        request.setSerialNo(turbocharger.getSerialNo());
        request.setStatus(turbocharger.getStatus());
        request.setPosition(turbocharger.getPosition());
        if(turbocharger.getClient() != null) {
        request.setClientEmail(turbocharger.getClient().getEmail());
        }
        return request;
    }
}
