package com.tpibackend.ruta_service.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rutaId;

    @Column(nullable = false)
    Long requestId;

    Integer totalTramos;
    Integer totalDepots;

    @Column(precision = 10, scale = 2)
    BigDecimal totalDistanceKm;

    Integer estimatedTimeMin;

    @Column(precision = 12, scale = 2)
    BigDecimal estimatedCost;

    @CreationTimestamp
    LocalDateTime createdAt;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    List<Segmento> segmentos = new ArrayList<>();

    @Column(nullable = false)
    Long solicitudId;
}