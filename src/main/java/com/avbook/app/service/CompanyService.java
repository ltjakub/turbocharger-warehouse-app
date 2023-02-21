package com.avbook.app.service;

import com.avbook.app.api.dto.CompanyRequest;
import com.avbook.app.entity.Company;
import com.avbook.app.exception.CompanyException;
import com.avbook.app.exception.ErrorMessage;
import com.avbook.app.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void addNewCompany(CompanyRequest request) {
        Company company = Company.builder()
                .name(request.getName())
                .build();
        companyRepository.save(company);
    }
    public Company getCompanyById(UUID id) {
        return companyRepository.findById(id).orElseThrow(() -> new CompanyException(ErrorMessage.COMPANY_NOT_FOUND));
    }
}
