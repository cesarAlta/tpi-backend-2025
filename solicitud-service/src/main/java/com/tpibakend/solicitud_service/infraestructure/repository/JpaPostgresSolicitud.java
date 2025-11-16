package com.example.solicitudservice.repository;

import com.example.solicitudservice.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    Optional<Solicitud> findByRequestNumber(String requestNumber);
}