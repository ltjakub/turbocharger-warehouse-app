package com.avbook.app.api.controller;

import com.avbook.app.api.dto.TurbochargerDto;
import com.avbook.app.service.TurbochargerService;
import com.avbook.app.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/turbocharger")
public class TurbochargerController {
    private final TurbochargerService turbochargerService;

    @PostMapping
    public void addTurbocharger(@Valid @RequestBody TurbochargerDto request, @AuthenticationPrincipal User user) {
        turbochargerService.addTurbocharger(request, user);
    }

    @GetMapping
    public List<TurbochargerDto> getAllByUserCompanyId(@AuthenticationPrincipal User user) {
        return turbochargerService.getAllByUserCompanyId(user);
    }
}
