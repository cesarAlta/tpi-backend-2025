package com.tpibackend.cliente_service.infrastructure.controller;

import com.tpibackend.cliente_service.application.ClientService;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientRequest;
import com.tpibackend.cliente_service.infrastructure.controller.dto.ClientResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/document/{document}")
    ResponseEntity<?> getByDocument(@PathVariable String document) {
        Long id  = clientService.getByDocument(document);
        return ResponseEntity.ok(id);
    }

    @PostMapping
    ResponseEntity<?> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok("Create client endpoint");
    }

}
