package com.tpibakend.cliente_service.infraestructure.repository;

import com.tpibakend.cliente_service.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostgresClient extends JpaRepository<Client,Long> {
}

/*@Repository
public interface JpaPostgresClient extends JpaRepository<Client,Long> {
    Optional<Client> findByEmail(String email);
}*/