package com.avbook.app.repository;

import com.avbook.app.entity.Turbocharger;
import com.avbook.app.entity.TurbochargerStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TurbochargerRepository extends CrudRepository<Turbocharger, UUID> {
    List<Turbocharger> findAllByCompanyId(UUID uuid);
    @Query("SELECT t FROM Turbocharger t WHERE t.company.id = :companyId AND t.status = :status")
    List<Turbocharger> findAllByCompanyIdAndStatus(@Param("companyId") UUID companyId, @Param("status") TurbochargerStatus status);
}
