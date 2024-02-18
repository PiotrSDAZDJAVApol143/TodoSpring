package com.example.listazadanspring.dto;

import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.model.TaskGroup;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class GroupReadModel {
    private String description;
    private LocalDateTime deadline;
    private Set<GroupTaskReadModel> tasksFromGroup;

    public GroupReadModel(TaskGroup source){
        description= source.getDescription();
        source.getTaskList().stream()
                .map(Task::getDeadline)
                .max(LocalDateTime::compareTo)
                .ifPresent(date-> deadline = date);
        tasksFromGroup = source.getTaskList().stream()
                .map(GroupTaskReadModel::new)
                .collect(Collectors.toSet());
    }


}
