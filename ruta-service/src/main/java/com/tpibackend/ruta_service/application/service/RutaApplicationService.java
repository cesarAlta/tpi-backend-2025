package com.tpibackend.ruta_service.application.service;

import com.tpibackend.ruta_service.application.dto.RutaRequestDTO;
import com.tpibackend.ruta_service.application.dto.RutaResponseDTO;
import com.tpibackend.ruta_service.domain.model.Ruta;
import com.tpibackend.ruta_service.infrastructure.client.GeoApiClient;
import com.tpibackend.ruta_service.infrastructure.client.dto.DistanciaDTO;
import com.tpibackend.ruta_service.infrastructure.repository.JpaRutaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.stereotype.Service;


@Service
@Getter(AccessLevel.PACKAGE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RutaApplicationService {

    JpaRutaRepository rutaRepository;

    private final GeoApiClient geoApiClient;

    public DistanciaDTO calcularDistancia(String origen, String destino) {
        return geoApiClient.obtenerDistancia(origen, destino);
    }

    public RutaResponseDTO createRuta(RutaRequestDTO dto) {

        // Ruta nueva
        Ruta ruta = new Ruta();
        ruta.setRequestId(dto.getRequestId());
        ruta.setTotalTramos(0);
        ruta.setTotalDepots(0);

        ruta = rutaRepository.save(ruta);

        return RutaResponseDTO.from(ruta);
    }

    public RutaResponseDTO getRuta(Long id){
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RUTA_NOT_FOUND"));

        return RutaResponseDTO.from(ruta);
    }
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
