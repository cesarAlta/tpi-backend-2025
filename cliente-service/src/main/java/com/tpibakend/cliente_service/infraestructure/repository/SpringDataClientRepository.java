package com.tpibakend.cliente_service.infraestructure.repository;

import com.tpibakend.cliente_service.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataClientRepository extends JpaRepository<Client,Long> {
    Optional<Long> findByDocument(String document);
}
