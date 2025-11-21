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
@Table(name = "segment")
public class Segmento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "segment_id")
    private Long segmentoId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Ruta ruta;

    private String originType;

    private BigDecimal originLat;
    private BigDecimal originLng;

    private BigDecimal destLat;
    private BigDecimal destLng;

    @Enumerated(EnumType.STRING)
    private SegmentType segmentType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(precision = 10, scale = 2)
    private BigDecimal estimatedDistanceKm;

    private Integer estimatedTimeMin;

    @Column(precision = 12, scale = 2)
    private BigDecimal estimatedCost;

    @Column(precision = 10, scale = 2)
    private BigDecimal actualDistanceKm;

    private Integer actualTimeMin;

    @Column(precision = 12, scale = 2)
    private BigDecimal actualCost;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Long truckId;  // viene del camion-service
}
