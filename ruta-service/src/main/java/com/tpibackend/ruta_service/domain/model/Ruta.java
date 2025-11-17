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
@Table(name = "Ruta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutaId;

    private Long requestId;

    private Integer totalTramos;
    private Integer totalDepots;
    private BigDecimal totalDistanceKm;
    private Integer estimatedTimeMin;
    private BigDecimal estimatedCost;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    List<Segmento> segmentos = new ArrayList<>();
}

// @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
// private List<Segmento> segmentos = new ArrayList<>();