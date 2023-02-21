package com.avbook.app.api.controller;

import com.avbook.app.api.dto.ClientDto;
import com.avbook.app.api.dto.ClientRequest;
import com.avbook.app.entity.Client;
import com.avbook.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{email}")
    public ClientDto getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);
    }
    @PostMapping
    public void createClient(@RequestBody ClientRequest request) {
        clientService.createClient(request);
    }
}
