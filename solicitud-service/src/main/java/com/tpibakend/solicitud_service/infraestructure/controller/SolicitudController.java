package com.tpibakend.solicitud_service.infraestructure.controller;

import com.tpibakend.solicitud_service.application.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;

    @PostMapping
    public ResponseEntity<Solicitud> registrar(@RequestBody SolicitudRequestDTO dto) {
        return ResponseEntity.ok(service.crearSolicitud(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerSolicitud(id));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Solicitud> cambiarEstado(
            @PathVariable Long id,
            @RequestBody EstadoUpdateDTO estadoDto
    ) {
        return ResponseEntity.ok(service.actualizarEstado(id, estadoDto.getNuevoEstado()));
    }
}
