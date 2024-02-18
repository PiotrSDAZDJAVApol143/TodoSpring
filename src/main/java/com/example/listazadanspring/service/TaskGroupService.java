package com.example.listazadanspring.service;

import com.example.listazadanspring.dto.GroupReadModel;
import com.example.listazadanspring.dto.GroupWriteModel;
import com.example.listazadanspring.model.TaskGroup;
import com.example.listazadanspring.repository.TaskGroupRepository;
import com.example.listazadanspring.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {

    private TaskGroupRepository taskGroupRepository;
    private TaskRepository taskRepository;

    public TaskGroupService(TaskGroupRepository taskGroupRepository, TaskRepository taskRepository) {
        this.taskGroupRepository = taskGroupRepository;
        this.taskRepository = taskRepository;
    }

    public GroupReadModel createGroup(GroupWriteModel source) {
        TaskGroup result = taskGroupRepository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return taskGroupRepository.findAllGroups()
                .stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if (taskRepository.existsByDoneCheckIsFalseAndId(groupId)) {
            throw new IllegalStateException("Check your group task. Group has undone tasks.");
        }
        TaskGroup result = taskGroupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Task group with given ID not found"));
        result.setDoneCheck(!result.isDoneCheck());
    }


}
