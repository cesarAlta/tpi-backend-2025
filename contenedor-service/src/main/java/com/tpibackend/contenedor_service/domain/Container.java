package com.tpibackend.contenedor_service.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "container_id", nullable = false, unique = true)
    Long containerId;

    @Column(name = "code", length = 50, nullable = false, unique = true)
    String code;

    @Column(name = "weight_kg", precision = 10, scale = 2, nullable = false)
    BigDecimal weightKg;

    @Column(name = "volume_m3", precision = 10, scale = 3, nullable = false)
    BigDecimal volumeM3;

    @JoinColumn(name = "client_id", nullable = false)
    Long clientId;

    public static Container createNew(BigDecimal weightKg, BigDecimal volumeM3, Long clientId) {
        return new Container(null, UUID.randomUUID().toString(), weightKg, volumeM3, clientId);
    }
}
