package com.tpibackend.ruta_service.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ruta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long rutaId;

    @Column(name = "request_id", nullable = false)
    private Long requestId;

    private Integer totalTramos;
    private Integer totalDepots;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalDistanceKm;

    private Integer estimatedTimeMin;

    @Column(precision = 12, scale = 2)
    private BigDecimal estimatedCost;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Segmento> segmentos = new ArrayList<>();
}