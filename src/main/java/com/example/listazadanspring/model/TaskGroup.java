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
@Table(name = "tasks_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;
    @Column(name = "description")
    @NotNull
    private String description;
    @Column(name = "done_check")
    private boolean doneCheck;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskGroup")

    private Set<Task> taskList;

  //  @Embedded
  //  private Audit audit = new Audit();


}
