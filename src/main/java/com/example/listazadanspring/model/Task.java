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
//@Table(name = "tasks")
public class Task{
    //test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;
    //@Column(name = "description")
    @NotNull
    private String description;
   // @Column(name = "done_check")
    private boolean doneCheck;
    private LocalDateTime deadline;

   @Embedded
   @Setter(AccessLevel.PRIVATE)
   @Getter(AccessLevel.NONE)
   private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup taskGroup;

    public void updateFrom(final Task source){
        description = source.description;
        doneCheck = source.doneCheck;
        deadline = source.deadline;
    }
    public Task(String description, LocalDateTime deadline){
        this.deadline=deadline;
        this.description=description;
    }

}
