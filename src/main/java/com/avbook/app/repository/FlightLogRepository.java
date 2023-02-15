package com.avbook.app.repository;

import com.avbook.app.entity.FlightLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FlightLogRepository extends JpaRepository<FlightLog, UUID> {
    List<FlightLog> findFlightLogsByUser_Id(UUID id);
}
