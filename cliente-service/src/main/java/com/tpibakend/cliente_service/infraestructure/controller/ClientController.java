package com.tpibakend.cliente_service.infraestructure.controller;

import com.tpibakend.cliente_service.application.ClientService;
import com.tpibakend.cliente_service.infraestructure.controller.dto.ClientRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clients")
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class ClientController {

    ClientService clientService;

    @PostMapping
    @GetMapping("/{id}")
    ResponseEntity<?> getClient(@PathVariable Long id) {
        return ResponseEntity.ok("Client service is running");
    }
    @GetMapping("/{document}")
    ResponseEntity<?> getByDocument(@PathVariable String document) {
        Long id = clientService.getByDocument(document);
        return ResponseEntity.ok(id);
    }
    ResponseEntity<?> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.ok("Create client endpoint");
    }

}
