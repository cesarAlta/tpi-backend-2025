package com.tpibackend.cliente_service.infrastructure.controller;

import com.tpibackend.cliente_service.application.ClientService;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientRequest;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/clientes")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ClientController {

    ClientService clientService;

    @GetMapping("/{id}")
    ResponseEntity<?> getClient(@PathVariable Long id) {
        ClientResponse client = clientService.getClient(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    ResponseEntity<?> getAll() {
        List<ClientResponse> clients = clientService.getAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/keycloak/{keycloakId}")
    ResponseEntity<?> getClientIdByKeycloakId(@PathVariable String keycloakId) {
        Long clientId = clientService.getClientIdByKeycloakId(keycloakId);
        if(Objects.isNull(clientId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Map.of("clientId", clientId));
    }

    @PostMapping
    ResponseEntity<?> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        Long clientId = clientService.registerClient(clientRequest);
        return ResponseEntity.ok(Map.of("clientId", clientId));
    }

}
