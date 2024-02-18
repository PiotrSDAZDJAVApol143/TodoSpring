package com.example.listazadanspring.dto;

import com.example.listazadanspring.model.TaskGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class GroupWriteModel {

private String description;
private Set<GroupTaskWriteModel> tasksToWrite;

public TaskGroup toGroup(){
    var result = new TaskGroup();
    result.setDescription(description);
    result.setTaskList(tasksToWrite.stream()
            .map(GroupTaskWriteModel::toTask)
            .collect(Collectors.toSet())
    );
    return result;
}

}
