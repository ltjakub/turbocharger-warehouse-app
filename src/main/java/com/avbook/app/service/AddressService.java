package com.avbook.app.service;

import com.avbook.app.api.dto.AddressDto;
import com.avbook.app.api.dto.ClientRequest;
import com.avbook.app.entity.Address;
import com.avbook.app.entity.Client;
import com.avbook.app.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address createAddress(ClientRequest clientRequest) {
        List<Client> list = new ArrayList<>();
        Address address = Address.builder()
                .zip(clientRequest.getZip())
                .street(clientRequest.getStreet())
                .state(clientRequest.getState())
                .city(clientRequest.getCity())
                .clients(list)
                .build();
        return addressRepository.save(address);
    }
}
