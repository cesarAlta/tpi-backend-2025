package com.tpibakend.tarifa_service.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long tariffId;

    @Column(length = 150, nullable = false)
    String name;

    @Column( precision = 10, scale = 2, nullable = false)
    BigDecimal baseCostPerKm;

    @Column(precision = 10, scale = 3, nullable = false)
    BigDecimal volumeRangeMin;

    @Column(precision = 10, scale = 3, nullable = false)
    BigDecimal volumeRangeMax;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal weightRangeMin;

    @Column( precision = 10, scale = 2, nullable = false)
    BigDecimal weightRangeMax;

    @Column( precision = 10, scale = 2, nullable = false)
    BigDecimal storageCostPerDay;

    @Column(precision = 10, scale = 2, nullable = false)
    BigDecimal fuelPricePerLiter;

    @Column( precision = 10, scale = 2, nullable = false)
    BigDecimal fixedPricePerSection;

    @Column( nullable = false, updatable = false)
    LocalDateTime createdAt;

}
