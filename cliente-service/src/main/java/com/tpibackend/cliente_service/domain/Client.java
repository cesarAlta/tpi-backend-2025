package com.tpibackend.cliente_service.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, unique = true)
    Long clientId;
    String name;
    @Column(nullable = false, unique = true)
    String document;
    String phone;
    String email;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @Column(unique = true, nullable = false)
    String keycloakId;

    private Client(String name, String document, String phone, String email, LocalDateTime now, String keycloakId) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.email = email;
        this.createdAt = now;
        this.keycloakId = keycloakId;
    }

    public static Client createNew(String name, String email, String document, String phone, String keycloakId) {
        return new Client(name, document, phone, email,
                LocalDateTime.now(),keycloakId);
    }
}
