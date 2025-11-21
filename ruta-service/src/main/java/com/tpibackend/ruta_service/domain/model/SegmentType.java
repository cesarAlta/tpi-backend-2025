package com.tpibackend.ruta_service.domain.model;

public enum SegmentType {
    ORIG_DEST,   // Origen → Destino
    ORIG_DEP,    // Origen → Depósito
    DEP_DEP,     // Depósito → Depósito
    DEP_DEST     // Depósito → Destino
}