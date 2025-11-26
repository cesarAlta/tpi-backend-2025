package com.tpibackend.ruta_service.application.service;

import com.tpibackend.ruta_service.application.dto.RutaRequestDTO;
import com.tpibackend.ruta_service.application.dto.RutaResponseDTO;
import com.tpibackend.ruta_service.domain.model.Ruta;
import com.tpibackend.ruta_service.infrastructure.client.GeoApiClient;
import com.tpibackend.ruta_service.infrastructure.client.dto.DistanciaDTO;
import com.tpibackend.ruta_service.infrastructure.controller.dto.KmTiempoEstimadoConsumoProm;
import com.tpibackend.ruta_service.infrastructure.repository.JpaRutaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RutaApplicationService {

    JpaRutaRepository rutaRepository;
    GeoApiClient geoApiClient;

    public DistanciaDTO calcularDistancia(String origen, String destino) {
        return geoApiClient.obtenerDistancia(origen, destino);
    }

    public RutaResponseDTO createRuta(RutaRequestDTO dto) {

        // Ruta nueva
//        Ruta nuevaRuta = Ruta.createRuta(
//                dto.origenLat(),
//                dto.ddestinoLng(),
//                dto.destinoLat(),
//                dto.ddestinoLng()
//        );
        Ruta ruta = new Ruta();
        ruta.setRequestId(1L);
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

    public KmTiempoEstimadoConsumoProm calcularDistanciaDirectaYTiempoEstimado(Double origenLat, Double origenLon,
                                                                               Double destinoLat, Double destinoLon) {
        DistanciaDTO distanciaDTO = geoApiClient.obtenerDistancia(
                origenLat + "," + origenLon,
                destinoLat + "," + destinoLon
        );

        Double distanciaKm = distanciaDTO.getKilometros();
        String tiempoMin = distanciaDTO.getDuracionTexto();

        // Supongamos un consumo promedio de 8 litros cada 100 km
        BigDecimal consumoPromedio = BigDecimal.valueOf((distanciaKm * 8) / 100);

        return new KmTiempoEstimadoConsumoProm(distanciaKm, tiempoMin, consumoPromedio);
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
