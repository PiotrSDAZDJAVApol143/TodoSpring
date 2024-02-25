package com.example.listazadanspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Getter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @NotNull(message = "Project's description must not be empty")
    private String description;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> groups;
    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectStep> steps;

    void setId(final Long id) {
        this.id = id;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    Set<TaskGroup> getGroups() {
        return groups;
    }

    void setGroups(final Set<TaskGroup> groups) {
        this.groups = groups;
    }

    void setSteps(final Set<ProjectStep> steps) {
        this.steps = steps;
    }

}

