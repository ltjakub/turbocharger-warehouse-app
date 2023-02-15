package com.avbook.app.api.controller;

import com.avbook.app.api.dto.FlightLogRequest;
import com.avbook.app.entity.FlightLog;
import com.avbook.app.service.FlightLogService;
import com.avbook.app.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight-log")
public class FlightLogController {
    private final FlightLogService flightLogService;
    @PostMapping
    public void createFlightLog(@RequestBody FlightLogRequest request, @AuthenticationPrincipal User user) {
        flightLogService.create(request, user);
    }
    @GetMapping("/{id}")
    public List<FlightLog> getFlightLogById(@PathVariable UUID id) {
        return flightLogService.getById(id);
    }
}
