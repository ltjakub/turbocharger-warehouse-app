package com.avbook.app.service;

import com.avbook.app.api.dto.TurbochargerDtoMapper;
import com.avbook.app.api.dto.TurbochargerDto;
import com.avbook.app.entity.Client;
import com.avbook.app.entity.Company;
import com.avbook.app.entity.Turbocharger;
import com.avbook.app.repository.TurbochargerRepository;
import com.avbook.app.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TurbochargerService {
    private final TurbochargerRepository turbochargerRepository;
    private final CompanyService companyService;
    private final ClientService clientService;

    public void addTurbocharger(TurbochargerDto request, User user) {
        Client client = null;
        if (isValidUser(request.getCompanyId(), user)) {
            Company company = companyService.getCompanyById(request.getCompanyId());
            if(request.getClientId() != null) {
            client = clientService.getClientById(request.getClientId());
            }
            Turbocharger turbocharger = Turbocharger.builder()
                    .company(company)
                    .serialNo(request.getSerialNo())
                    .status(request.getStatus())
                    .brand(request.getBrand())
                    .model(request.getModel())
                    .engineType(request.getEngineType())
                    .volume(request.getVolume())
                    .power(request.getPower())
                    .producedFrom(request.getProducedFrom())
                    .producedTo(request.getProducedTo())
                    .position(request.getPosition())
                    .client(client)
                    .build();
            turbochargerRepository.save(turbocharger);
        }

    }



    public List<TurbochargerDto> getAllByCompanyId(UUID companyID, User user) {
        if (isValidUser(companyID, user)) {
            return turbochargerRepository.findAllByCompanyId(companyID)
                    .stream()
                    .map(TurbochargerDtoMapper::map)
                    .toList();
        }
    return new ArrayList<>();
    }


    private boolean isValidUser(UUID companyID, User user) {
        return companyID.equals(user.getCompany().getId());
    }

    public void deleteById(UUID id) {
        turbochargerRepository.deleteById(id);
    }
}
