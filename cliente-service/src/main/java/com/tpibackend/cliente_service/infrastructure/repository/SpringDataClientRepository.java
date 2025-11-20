package com.tpibackend.cliente_service.infrastructure.repository;

import com.tpibackend.cliente_service.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByDocument(String document);
}