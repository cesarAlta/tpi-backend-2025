package com.tpibackend.ruta_service.infrastructure.repository;

import com.tpibackend.ruta_service.domain.model.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JpaSegmentoRepository extends JpaRepository<Segmento, Long> {

    // Devuelve todos los segmentos pertenecientes a una ruta concreta
    List<Segmento> findByRutaId(Long rutaId);
}
