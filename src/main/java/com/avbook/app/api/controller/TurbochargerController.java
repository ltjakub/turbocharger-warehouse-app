package com.avbook.app.api.controller;

import com.avbook.app.api.dto.TurbochargerDto;
import com.avbook.app.entity.TurbochargerStatus;
import com.avbook.app.service.TurbochargerService;
import com.avbook.app.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/turbocharger")
public class TurbochargerController {
    private final TurbochargerService turbochargerService;

    @PostMapping
    public void addTurbocharger(@RequestBody TurbochargerDto request, @AuthenticationPrincipal User user) {
        turbochargerService.addTurbocharger(request, user);
    }

    @GetMapping
    public List<TurbochargerDto> getAllByUserCompanyIdAndStatus(@AuthenticationPrincipal User user, @RequestParam(required = false) TurbochargerStatus status) {
        return turbochargerService.getAllByUserCompanyIdAndStatus(user, status);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        turbochargerService.deleteById(id);
    }

    @PatchMapping
    public void patchTurbocharger(@RequestBody TurbochargerDto request) {
        turbochargerService.patchTurbocharger(request);
    }
}
