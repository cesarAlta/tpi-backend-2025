package com.tpibakend.solicitud_service.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long requestId;
    @Column(length = 50, unique = true)
    String requestNumber;
    Long containerId;
    Long clientId;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    List<History> histories;
    @Column(precision = 12, scale = 2)
    BigDecimal estimatedCost;
    Integer estimatedTimeMin;
    @Column(precision = 12, scale = 2)
    BigDecimal finalCost;
    Integer actualTimeMin;
    LocalDateTime createdAt;

    public Request(String requestNumber, Long containerId, Long clientId, LocalDateTime createdAt) {
        this.requestNumber = requestNumber;
        this.containerId = containerId;
        this.clientId = clientId;
        this.createdAt = createdAt;
    }
    public void addNewHistory() {
        if(histories == null) histories = new ArrayList<>();
        History h = History.CreateDraftHistory(this);
        this.histories.add(h);
    }
    public static Request createDraftRequest(Long clientId, Long containerId, String requestNumber) {
        Request newRequest =  new Request(requestNumber, containerId, clientId, LocalDateTime.now());
        newRequest.addNewHistory();
        return newRequest;
    }

    public History getCurrentHistoryState() {
        if (histories == null || histories.isEmpty()) {
            return null;
        }
        return histories.get(histories.size() - 1);
    }
}
