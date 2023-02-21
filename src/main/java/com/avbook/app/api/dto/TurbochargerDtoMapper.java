package com.avbook.app.api.dto;

import com.avbook.app.entity.Turbocharger;

public class TurbochargerDtoMapper {
    public static TurbochargerDto map(Turbocharger turbocharger) {
        TurbochargerDto request = new TurbochargerDto();
        request.setId(turbocharger.getId());
        request.setCompanyId(turbocharger.getCompany().getId());
        request.setSerialNo(turbocharger.getSerialNo());
        request.setStatus(turbocharger.getStatus());
        request.setBrand(turbocharger.getBrand());
        request.setModel(turbocharger.getModel());
        request.setEngineType(turbocharger.getEngineType());
        request.setPower(turbocharger.getPower());
        request.setVolume(turbocharger.getVolume());
        request.setProducedFrom(turbocharger.getProducedFrom());
        request.setProducedTo(turbocharger.getProducedTo());
        request.setPosition(turbocharger.getPosition());
        request.setClientId(turbocharger.getClient().getId());
        return request;
    }
}
