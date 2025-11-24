package com.tpibackend.ruta_service.infrastructure.controller;

import com.tpibackend.ruta_service.application.service.RutaApplicationService;
import com.tpibackend.ruta_service.application.dto.RutaRequestDTO;
import com.tpibackend.ruta_service.application.dto.RutaResponseDTO;

import com.tpibackend.ruta_service.infrastructure.controller.dto.KmTiempoEstimadoConsumoProm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rutas")
@RequiredArgsConstructor
public class RutaController {

    private final RutaApplicationService rutaService;

    @PostMapping
    public ResponseEntity<RutaResponseDTO> createRuta(@RequestBody RutaRequestDTO dto) {
        return ResponseEntity.ok(rutaService.createRuta(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaResponseDTO> getRuta(@PathVariable Long id) {
        return ResponseEntity.ok(rutaService.getRuta(id));
    }
    @GetMapping("/distancia-directa")
    public ResponseEntity<?> getRuta(
            @RequestParam Double origenLat,
            @RequestParam Double origenLon,
            @RequestParam Double destinoLat,
            @RequestParam Double destinoLon
    ) {
        KmTiempoEstimadoConsumoProm resp = rutaService.calcularDistanciaDirectaYTiempoEstimado(
                origenLat, origenLon, destinoLat, destinoLon
        );
        return ResponseEntity.ok(resp);
    }
}