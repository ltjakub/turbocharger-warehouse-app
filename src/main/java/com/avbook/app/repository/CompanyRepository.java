package com.avbook.app.repository;

import com.avbook.app.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CompanyRepository extends CrudRepository<Company, UUID> {
}
