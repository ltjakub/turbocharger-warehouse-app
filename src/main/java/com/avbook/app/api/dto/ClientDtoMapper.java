package com.avbook.app.api.dto;


import com.avbook.app.entity.Client;

import java.util.List;

public class ClientDtoMapper {
    public static ClientDto map(Client client) {
        List<TurbochargerDto> turbochargerDtos = client.getTurbochargers()
                .stream()
                .map(TurbochargerDtoMapper::map)
                .toList();
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setAddress(AddressDtoMapper.map(client.getAddress()));
        dto.setCompanyId(client.getCompany().getId());
        dto.setEmail(client.getEmail());
        dto.setTurbochargers(turbochargerDtos);
        return dto;
    }

}
