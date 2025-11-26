package com.tpibackend.ruta_service.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.tpibackend.ruta_service.domain.model.Ruta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Segmento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long segmentoId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    Ruta ruta;

    String originType;

    BigDecimal originLat;
    BigDecimal originLng;

    BigDecimal destLat;
    BigDecimal destLng;

    @Enumerated(EnumType.STRING)
    SegmentType segmentType;

    @Enumerated(EnumType.STRING)
    Status status;

    @Column(precision = 10, scale = 2)
    BigDecimal estimatedDistanceKm;

    Integer estimatedTimeMin;

    @Column(precision = 12, scale = 2)
    BigDecimal estimatedCost;

    @Column(precision = 10, scale = 2)
    BigDecimal actualDistanceKm;

    Integer actualTimeMin;

    @Column(precision = 12, scale = 2)
    BigDecimal actualCost;

    LocalDateTime startTime;
    LocalDateTime endTime;

    Long truckId;  // viene del camion-service
}
