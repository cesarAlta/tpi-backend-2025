package com.tpibackend.ruta_service.infrastructure.controller;

import com.tpibackend.ruta_service.application.service.SegmentoApplicationService;
import com.tpibackend.ruta_service.infrastructure.controller.dto.SegmentoRequest;
import com.tpibackend.ruta_service.infrastructure.controller.dto.SegmentoResponse;
import com.tpibackend.ruta_service.infrastructure.controller.SegmentoMapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/segmentos")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SegmentoController {

    SegmentoApplicationService service;

    @PostMapping
    public ResponseEntity<SegmentoResponse> create(@RequestBody SegmentoRequest request) {

        val ruta = service.getRuta(request.getRutaId()); // esto depende de tu servicio
        val segmento = SegmentoMapper.toEntity(request, ruta);

        val saved = service.createSegmento(segmento);

        return ResponseEntity.ok(SegmentoMapper.toResponse(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SegmentoResponse> getById(@PathVariable Long id) {
        val segmento = service.getSegmento(id);
        return ResponseEntity.ok(SegmentoMapper.toResponse(segmento));
    }

    @GetMapping("/ruta/{rutaId}")
    public ResponseEntity<List<SegmentoResponse>> getByRuta(@PathVariable Long rutaId) {
        val segmentos = service.getSegmentosByRuta(rutaId)
                .stream()
                .map(SegmentoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(segmentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SegmentoResponse> update(
            @PathVariable Long id,
            @RequestBody SegmentoRequest request) {

        val existing = service.getSegmento(id);
        existing.setEstimatedDistanceKm(request.getEstimatedDistanceKm());
        existing.setEstimatedCost(request.getEstimatedCost());
        existing.setEstimatedTimeMin(request.getEstimatedTimeMin());

        val updated = service.updateSegmento(existing);
        return ResponseEntity.ok(SegmentoMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSegmento(id);
        return ResponseEntity.noContent().build();
    }
}