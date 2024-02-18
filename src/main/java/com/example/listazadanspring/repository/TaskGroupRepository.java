package com.example.listazadanspring.repository;

import com.example.listazadanspring.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {
    List<TaskGroup> findAllGroups();
    Optional<TaskGroup> findById(Integer id);
    TaskGroup save(TaskGroup entity);


}
