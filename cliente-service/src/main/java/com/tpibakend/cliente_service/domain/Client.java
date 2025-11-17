package com.tpibakend.cliente_service.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, unique = true)
    Long clientId;
    String name;
    String document;
    String phone;
    String email;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
