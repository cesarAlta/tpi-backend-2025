package com.tpibackend.ruta_service.application.service;

import com.tpibackend.ruta_service.application.dto.RutaRequestDTO;
import com.tpibackend.ruta_service.application.dto.RutaResponseDTO;
import com.tpibackend.ruta_service.application.exception.RutaNotFoundException;
import com.tpibackend.ruta_service.domain.model.Ruta;
import com.tpibackend.ruta_service.infrastructure.repository.JpaRutaRepository;
import com.tpibackend.ruta_service.infrastructure.repository.JpaSegmentoRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RutaApplicationService {

    private final JpaRutaRepository rutaRepository;
    private final JpaSegmentoRepository segmentoRepository;

    public RutaApplicationService(JpaRutaRepository rutaRepository,
                                  JpaSegmentoRepository segmentoRepository) {
        this.rutaRepository = rutaRepository;
        this.segmentoRepository = segmentoRepository;
    }

 /*   public RutaResponseDTO crearRuta(RutaRequestDTO dto) {

        Ruta ruta = new Ruta();
        ruta.setRequestId(dto.getRequestId());
        ruta.setCreatedAt(LocalDateTime.now());

        // Valores iniciales (sin cálculos)
        ruta.setTotalTramos(0);
        ruta.setTotalDepots(0);
        ruta.setTotalDistanceKm(BigDecimal.ZERO);
        ruta.setEstimatedCost(BigDecimal.ZERO);
        ruta.setEstimatedTimeMin(0);

        Ruta guardada = rutaRepository.save(ruta);

        return RutaResponseDTO.from(guardada);
    }

    public RutaResponseDTO obtenerRuta(Long id) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new RutaNotFoundException(id));

        return RutaResponseDTO.from(ruta);
    }

    public List<RutaResponseDTO> obtenerTodas() {
        return rutaRepository.findAll()
                .stream()
                .map(RutaResponseDTO::from)
                .toList();
    }*/
}