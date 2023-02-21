package com.avbook.app.api.dto;

import com.avbook.app.entity.Address;

public class AddressDtoMapper {
    public static AddressDto map(Address address) {
        AddressDto dto = new AddressDto();
        dto.setStreet(address.getStreet());
        dto.setZip(address.getZip());
        dto.setState(address.getState());
        dto.setCity(address.getCity());
        dto.setId(address.getId());
        return dto;
    }
}
