package com.example.listazadanspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "project_steps")
public class ProjectStep {
    @Getter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @NotBlank(message = "Project step's description must not be empty")
    private String description;
    @Getter
    private int daysToDeadline;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    void setId(final Long id) {
        this.id = id;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    void setDaysToDeadline(final int daysToDeadline) {
        this.daysToDeadline = daysToDeadline;
    }

    Project getProject() {
        return project;
    }

    void setProject(final Project project) {
        this.project = project;
    }


}
