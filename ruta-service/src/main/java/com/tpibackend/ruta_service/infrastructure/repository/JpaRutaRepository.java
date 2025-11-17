package com.tpibackend.ruta_service.infrastructure.repository;

import com.tpibackend.ruta_service.domain.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface JpaRutaRepository extends JpaRepository<Ruta, Long> {

    // Buscar una ruta por el ID de la solicitud asociada
    Optional<Ruta> findBySolicitudId(Long solicitudId);

    // (Opcional) Listar todas las rutas asociadas a una solicitud
    List<Ruta> findAllBySolicitudId(Long solicitudId);
}
