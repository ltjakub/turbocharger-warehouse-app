package com.avbook.app.repository;

import com.avbook.app.entity.Part;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PartRepository extends CrudRepository<Part, UUID> {
    @Modifying
    @Query("UPDATE Part p SET p.quantity = p.quantity + 1 WHERE p.id = :id")
    void incrementQuantityById(@Param("id") UUID id);

    @Modifying
    @Query("UPDATE Part p SET p.quantity = p.quantity - 1 WHERE p.id = :id")
    void decrementQuantityById(@Param("id") UUID id);
    @Modifying
    @Query("UPDATE Part p SET p.quantity = p.quantity + :number WHERE p.id = :id")
    void incrementQuantityById(@Param("id") UUID id, @Param("number") Integer number);
    @Modifying
    @Query("UPDATE Part p SET p.quantity = p.quantity - :number WHERE p.id = :id")
    void decrementQuantityById(@Param("id") UUID id, @Param("number") Integer number);
}
