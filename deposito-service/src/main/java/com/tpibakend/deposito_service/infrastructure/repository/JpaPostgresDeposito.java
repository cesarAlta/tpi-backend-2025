package com.tpibakend.deposito_service.infrastructure.repository;

import com.tpibakend.deposito_service.domain.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostgresDeposito extends JpaRepository<Deposito, Long> {
}
