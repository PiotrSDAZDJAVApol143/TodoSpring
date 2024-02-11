package com.example.listazadanspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    //test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;
    @Column(name = "description")
    @NotNull
    private String description;
    @Column(name = "doneCheck")
    private boolean doneCheck;
    private LocalDateTime deadline;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdOn;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private LocalDateTime updatedOn;

    public void updateFrom(final Task source){
        description = source.description;
        doneCheck = source.doneCheck;
        deadline = source.deadline;
    }
    // metoda ukrywająca ID
    @PrePersist
    void prePersist(){
        createdOn = LocalDateTime.now();
    }
    // Hibernetowa metoda wyświetli kiedy powstała kolumna (forma jednorazowego settera)
    @PreUpdate
    void preMarge(){
        updatedOn = LocalDateTime.now();
    }
}
