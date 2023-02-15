package com.avbook.app.service;

import com.avbook.app.api.dto.FlightLogRequest;
import com.avbook.app.entity.FlightLog;
import com.avbook.app.repository.FlightLogRepository;
import com.avbook.app.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightLogService {

    private final FlightLogRepository flightLogRepository;

    public void create(FlightLogRequest request, User user) {
        FlightLog flightLog = FlightLog.builder()
                .id(request.getId())
                .acRegistration(request.getAcRegistration())
                .instructor(request.getInstructor())
                .from(request.getFrom())
                .to(request.getTo())
                .takeoff(request.getTakeoff())
                .landing(request.getLanding())
                .landingQuantity(request.getLandingQuantity())
                .user(user)
                .build();
        flightLogRepository.save(flightLog);
    }
    public List<FlightLog> getById(UUID id) {
        return flightLogRepository.findFlightLogsByUser_Id(id);
    }
//    public FlightLog getByUserId()
}
