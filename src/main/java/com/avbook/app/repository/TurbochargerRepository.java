package com.avbook.app.repository;

import com.avbook.app.entity.Turbocharger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TurbochargerRepository extends CrudRepository<Turbocharger, UUID> {
    List<Turbocharger> findAllByCompanyId(UUID uuid);
}
