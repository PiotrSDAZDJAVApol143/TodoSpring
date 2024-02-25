package com.example.listazadanspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "tasks_groups")
public class TaskGroup {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    //@Column(name = "description")
    @Setter
    @Getter
    @NotNull(message = "Task group's description must not be empty")
    private String description;
    //@Column(name = "done_check")
    private boolean doneCheck;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskGroup")
    private Set<Task> taskList;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    void setId(final Long id) {
        this.id = id;
    }

    public boolean doneCheck() {
        return doneCheck;
    }

    public void setDone(final boolean done) {
        this.doneCheck = done;
    }

    public Set<Task> getTasks() {
        return taskList;
    }

    public void setTasks(final Set<Task> tasks) {
        this.taskList = tasks;
    }

    Project getProject() {
        return project;
    }

    void setProject(final Project project) {
        this.project = project;
    }
}
