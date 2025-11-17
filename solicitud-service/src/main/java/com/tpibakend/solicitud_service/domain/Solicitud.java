package com.tpibakend.solicitud_service.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Column(name = "request_number", unique = true, nullable = false, length = 50)
    private String requestNumber;

    @Column(name = "container_id", nullable = false)
    private Long containerId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private EstadoSolicitud status;

    @Column(name = "estimated_cost", precision = 12, scale = 2)
    private BigDecimal estimatedCost;

    @Column(name = "estimated_time_min")
    private Integer estimatedTimeMin;

    @Column(name = "final_cost", precision = 12, scale = 2)
    private BigDecimal finalCost;

    @Column(name = "actual_time_min")
    private Integer actualTimeMin;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
