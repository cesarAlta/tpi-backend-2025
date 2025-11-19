package com.tpibackend.ruta_service.application.service;

import com.tpibackend.ruta_service.domain.model.Segmento;
import com.tpibackend.ruta_service.infrastructure.repository.JpaSegmentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SegmentoApplicationService {

    JpaSegmentoRepository segmentoRepository;

    public Segmento createSegmento(Segmento segmento) {
        return segmentoRepository.save(segmento);
    }

    public Segmento getSegmento(Long id) {
        return segmentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SEGMENTO_NOT_FOUND"));
    }

    public List<Segmento> getSegmentosByRuta(Long rutaId) {
        return segmentoRepository.findByRutaId(rutaId);
    }

    public Segmento updateSegmento(Segmento segmento) {
        // Si necesitás validaciones futuras, irán aquí
        return segmentoRepository.save(segmento);
    }

    public void deleteSegmento(Long id) {
        if (!segmentoRepository.existsById(id)) {
            throw new RuntimeException("SEGMENTO_NOT_FOUND");
        }
        segmentoRepository.deleteById(id);
    }
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
