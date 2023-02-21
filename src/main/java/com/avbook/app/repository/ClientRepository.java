package com.avbook.app.repository;

import com.avbook.app.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {
    Optional<Client> getClientByEmail(String email);
}
