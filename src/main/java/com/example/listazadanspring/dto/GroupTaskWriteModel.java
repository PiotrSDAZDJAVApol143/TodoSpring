package com.example.listazadanspring.dto;

import com.example.listazadanspring.model.Task;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class GroupTaskWriteModel {
    private String description;
    private LocalDateTime deadline;

    public Task toTask(){
        return new Task(description,deadline);
    }
}
