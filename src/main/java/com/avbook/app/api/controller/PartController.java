package com.avbook.app.api.controller;

import com.avbook.app.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/part")
public class PartController {
    private final PartService partService;

    @PostMapping("/increment/{id}")
    public void incrementQuantity(@PathVariable UUID id) {
        partService.incrementQuantity(id);
    }

    @PostMapping("/decrement/{id}")
    public void decrementQuantity(@PathVariable UUID id) {
        partService.decrementQuantity(id);
    }
}
