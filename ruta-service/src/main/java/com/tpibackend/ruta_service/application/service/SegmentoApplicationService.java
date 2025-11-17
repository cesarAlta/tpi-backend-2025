package com.tpibackend.ruta_service.application.service;

import com.tpibackend.ruta_service.application.dto.SegmentoDTO;
import com.tpibackend.ruta_service.application.exception.RutaNotFoundException;
import com.tpibackend.ruta_service.application.exception.SegmentoNotFoundException;
import com.tpibackend.ruta_service.domain.model.Ruta;
import com.tpibackend.ruta_service.domain.model.Segmento;
import com.tpibackend.ruta_service.infrastructure.repository.JpaRutaRepository;
import com.tpibackend.ruta_service.infrastructure.repository.JpaSegmentoRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SegmentoApplicationService {

    private final JpaSegmentoRepository segmentoRepository;
    private final JpaRutaRepository rutaRepository;

    public SegmentoApplicationService(JpaSegmentoRepository segmentoRepository,
                                      JpaRutaRepository rutaRepository) {
        this.segmentoRepository = segmentoRepository;
        this.rutaRepository = rutaRepository;
    }

    /*public SegmentoDTO crearSegmento(Long rutaId, SegmentoDTO dto) {

        Ruta ruta = rutaRepository.findById(rutaId)
                .orElseThrow(() -> new RutaNotFoundException(rutaId));

        Segmento segmento = new Segmento();
        segmento.setRuta(ruta);
        segmento.setOriginType(dto.getOriginType());
        segmento.setOriginLat(dto.getOriginLat());
        segmento.setOriginLng(dto.getOriginLng());
        segmento.setDestLat(dto.getDestLat());
        segmento.setDestLng(dto.getDestLng());
        segmento.setSegmentType(dto.getSegmentType());
        segmento.setStatus("ESTIMADO");

        // Valores iniciales (sin cálculos)
        segmento.setEstimatedDistanceKm(BigDecimal.ZERO);
        segmento.setEstimatedTimeMin(0);
        segmento.setEstimatedCost(BigDecimal.ZERO);

        Segmento guardado = segmentoRepository.save(segmento);

        return SegmentoDTO.from(guardado);
    }

    public SegmentoDTO obtenerSegmento(Long id) {
        Segmento segmento = segmentoRepository.findById(id)
                .orElseThrow(() -> new SegmentoNotFoundException(id));

        return SegmentoDTO.from(segmento);
    }

    public List<SegmentoDTO> obtenerSegmentosPorRuta(Long rutaId) {
        return segmentoRepository.findByRutaId(rutaId)
                .stream()
                .map(SegmentoDTO::from)
                .toList();
    }*/
}