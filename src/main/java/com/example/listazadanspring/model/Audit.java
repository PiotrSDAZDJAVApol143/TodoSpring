package com.example.listazadanspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;



@Embeddable

class Audit {
    @Column(name = "created_on", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;
    @Column(name = "updated_on", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedOn;
    // metoda ukrywająca ID
    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
    }
    // Hibernetowa metoda wyświetli kiedy powstała kolumna (forma jednorazowego settera)
    @PreUpdate
    void preMerge() {
        updatedOn = LocalDateTime.now();
    }
}
