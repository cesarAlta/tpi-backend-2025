package com.tpibakend.tarifa_service.infraestructure.persistence;

import com.tpibakend.tarifa_service.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SpringDataTariff extends JpaRepository<Tariff, Long> {
    Tariff findTopByOrderByCreatedAtDesc();

    @Query("SELECT t FROM Tariff t WHERE :contWeight BETWEEN t.weightRangeMin AND t.weightRangeMax AND :contVol BETWEEN t.volumeRangeMin AND t.volumeRangeMax ORDER BY t.createdAt DESC")
    Tariff findLatestTariffByWeightAndVol(BigDecimal contWeight, BigDecimal contVol);
}
