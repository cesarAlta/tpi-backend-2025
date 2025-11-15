package com.tpibakend.tarifa_service.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@NoArgsConstructor
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id")
    Long tariffId;

    @Column(length = 150, nullable = false)
    String name;

    @Column(name = "base_cost_per_km", precision = 10, scale = 2, nullable = false)
    BigDecimal baseCostPerKm;

    @Column(name = "volume_range_min", precision = 10, scale = 3, nullable = false)
    BigDecimal volumeRangeMin;

    @Column(name = "volume_range_max", precision = 10, scale = 3, nullable = false)
    BigDecimal volumeRangeMax;

    @Column(name = "weight_range_min", precision = 10, scale = 2, nullable = false)
    BigDecimal weightRangeMin;

    @Column(name = "weight_range_max", precision = 10, scale = 2, nullable = false)
    BigDecimal weightRangeMax;

    @Column(name = "storage_cost_per_day", precision = 10, scale = 2, nullable = false)
    BigDecimal storageCostPerDay;

    @Column(name = "fuel_price_per_liter", precision = 10, scale = 2, nullable = false)
    private BigDecimal fuelPricePerLiter;

    @Column(name = "create_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

}
