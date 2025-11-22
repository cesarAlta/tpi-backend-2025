package com.tpibakend.solicitud_service.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long historyId;
    @Enumerated(EnumType.STRING)
    Status status;
    LocalDateTime changeAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    Request request;

    public History(Status status, LocalDateTime changeAt, Request request) {
        this.status = status;
        this.changeAt = changeAt;
        this.request = request;
    }

    public static History CreateDraftHistory(Request newRequest) {
        return new History( Status.BORRADOR, LocalDateTime.now(), newRequest);
    }
}
