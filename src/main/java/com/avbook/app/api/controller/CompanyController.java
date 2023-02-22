package com.avbook.app.api.controller;

import com.avbook.app.api.dto.CompanyRequest;
import com.avbook.app.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public void createCompany(@RequestBody CompanyRequest request) {
        companyService.addNewCompany(request);
    }
}
