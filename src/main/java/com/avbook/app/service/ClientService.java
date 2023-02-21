package com.avbook.app.service;

import com.avbook.app.api.dto.*;
import com.avbook.app.entity.Address;
import com.avbook.app.entity.Client;
import com.avbook.app.entity.Company;
import com.avbook.app.entity.Turbocharger;
import com.avbook.app.exception.CompanyException;
import com.avbook.app.exception.ErrorMessage;
import com.avbook.app.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final AddressService addressService;
    private final CompanyService companyService;

    public Client getClientById(UUID id) {
        return clientRepository.findById(id).orElseThrow(() -> new CompanyException(ErrorMessage.ENTITY_NOT_FOUND));
    }

    public ClientDto getClientByEmail(String email) {
        Client client = clientRepository.getClientByEmail(email).orElseThrow(() -> new CompanyException(ErrorMessage.ENTITY_NOT_FOUND));
        return ClientDtoMapper.map(client);
    }

    public void createClient(ClientRequest request) {
        Company company = companyService.getCompanyById(request.getCompanyId());
        Address address = addressService.createAddress(request);
        List<Turbocharger> turbochargerList = new ArrayList<>();

        Client client = Client.builder()
                .address(address)
                .company(company)
                .email(request.getEmail())
                .turbochargers(turbochargerList)
                .build();
        clientRepository.save(client);
    }
}
