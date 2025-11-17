package com.tpibakend.solicitud_service.infraestructure.repository;

import com.tpibakend.solicitud_service.domain.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaSolicitudRepository extends JpaRepository<Solicitud, Long> {
    Optional<Solicitud> findByRequestNumber(String requestNumber);
}