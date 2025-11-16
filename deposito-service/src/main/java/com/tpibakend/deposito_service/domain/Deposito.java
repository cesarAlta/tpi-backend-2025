package com.tpibakend.deposito_service.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "depositos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depot_id")
    Long depotId;

    @Column(length = 150, nullable = false)
    String name;

    @Column(length = 300, nullable = false)
    String address;

    @Column(precision = 10, scale = 7)
    BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    BigDecimal longitude;

    @Column(name = "daily_storage_cost", precision = 10, scale = 2)
    BigDecimal dailyStorageCost;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
