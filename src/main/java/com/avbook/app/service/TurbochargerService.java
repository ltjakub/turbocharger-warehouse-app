package com.avbook.app.service;

import com.avbook.app.api.dto.TurbochargerDtoMapper;
import com.avbook.app.api.dto.TurbochargerDto;
import com.avbook.app.entity.Client;
import com.avbook.app.entity.Company;
import com.avbook.app.entity.Turbocharger;
import com.avbook.app.entity.TurbochargerStatus;
import com.avbook.app.exception.ClientException;
import com.avbook.app.exception.CompanyException;
import com.avbook.app.exception.ErrorMessage;
import com.avbook.app.repository.ClientRepository;
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
    private final ClientRepository clientRepository;

    public void addTurbocharger(TurbochargerDto request, User user) {
        Turbocharger turbocharger;
        Client client;

        Company company = companyService.getCompanyById(user.getCompany().getId());
        if (request.getClientEmail() != null) {
            client = clientRepository.getClientByEmail(request.getClientEmail()).orElseThrow(() -> new ClientException(ErrorMessage.ENTITY_NOT_FOUND));
            turbocharger = createTurbochargerWithClient(request, client, company);
        } else {
            turbocharger = createTurbochargerWithoutClient(request, company);
        }

        turbochargerRepository.save(turbocharger);

    }

    private Turbocharger createTurbochargerWithClient(TurbochargerDto request, Client client, Company company) {
        return Turbocharger.builder()
                .company(company)
                .serialNo(request.getSerialNo())
                .status(request.getStatus())
                .position(request.getPosition())
                .client(client)
                .build();
    }

    private Turbocharger createTurbochargerWithoutClient(TurbochargerDto request, Company company) {
        return Turbocharger.builder()
                .company(company)
                .serialNo(request.getSerialNo())
                .status(request.getStatus())
                .position(request.getPosition())
                .build();
    }

    public List<TurbochargerDto> getAllByUserCompanyIdAndStatus(User user, TurbochargerStatus status) {
        List<Turbocharger> turbochargerList;
        if (user.getCompany().getId() != null) {
            UUID companyId = user.getCompany().getId();
            if (status == null) {
                turbochargerList = turbochargerRepository.findAllByCompanyId(companyId);
            } else {
                turbochargerList = turbochargerRepository.findAllByCompanyIdAndStatus(companyId, status);
            }
            return turbochargerList
                    .stream()
                    .map(TurbochargerDtoMapper::map)
                    .toList();
        }
        return new ArrayList<>();
    }

    public void deleteById(UUID id) {
        turbochargerRepository.deleteById(id);
    }

    public void patchTurbocharger(TurbochargerDto turbochargerDto) {
        Turbocharger turbocharger = turbochargerRepository.findById(turbochargerDto.getId()).orElseThrow(() -> new CompanyException(ErrorMessage.ENTITY_NOT_FOUND));
        if (!turbochargerDto.getClientEmail().isEmpty()) {
            Client client = clientRepository.getClientByEmail(turbochargerDto.getClientEmail()).orElseThrow(() -> new ClientException(ErrorMessage.ENTITY_NOT_FOUND));
            turbocharger.setClient(client);
        }
        turbocharger.setPosition(turbochargerDto.getPosition());
        turbocharger.setStatus(turbochargerDto.getStatus());
        turbocharger.setSerialNo(turbochargerDto.getSerialNo());
        turbochargerRepository.save(turbocharger);
    }
}
