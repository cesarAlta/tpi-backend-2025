package com.tpibakend.tarifa_service.infraestructure.persistence;

import com.tpibakend.tarifa_service.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataTariff extends JpaRepository<Tariff, Long> {
}
