package com.tpibackend.ruta_service.infrastructure.controller;

import com.tpibackend.ruta_service.application.service.RutaApplicationService;
import com.tpibackend.ruta_service.application.dto.RutaRequestDTO;
import com.tpibackend.ruta_service.application.dto.RutaResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rutas")
public class RutaController {

    private final RutaApplicationService rutaService;

    public RutaController(RutaApplicationService rutaService) {
        this.rutaService = rutaService;
    }

    @PostMapping
    public ResponseEntity<RutaResponseDTO> createRuta(@RequestBody RutaRequestDTO dto) {
        return ResponseEntity.ok(rutaService.createRuta(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaResponseDTO> getRuta(@PathVariable Long id) {
        return ResponseEntity.ok(rutaService.getRuta(id));
    }
}