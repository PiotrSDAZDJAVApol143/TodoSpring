package com.example.listazadanspring.service;

import com.example.listazadanspring.dto.GroupReadModel;
import com.example.listazadanspring.dto.GroupWriteModel;
import com.example.listazadanspring.model.TaskGroup;
import com.example.listazadanspring.repository.TaskGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskGroupService {

private TaskGroupRepository taskGroupRepository;

    public TaskGroupService(TaskGroupRepository taskGroupRepository) {
        this.taskGroupRepository = taskGroupRepository;
    }

    public GroupReadModel createGroup(GroupWriteModel source){
        TaskGroup result = taskGroupRepository.save(source.toGroup());
        return new GroupReadModel(result);
    }





}
