package com.example.listazadanspring.dto;

import com.example.listazadanspring.model.Task;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class GroupTaskReadModel {
public GroupTaskReadModel(Task source){
    description = source.getDescription();
    doneCheck = source.isDoneCheck();
}
    private String description;
    private boolean doneCheck;
}
