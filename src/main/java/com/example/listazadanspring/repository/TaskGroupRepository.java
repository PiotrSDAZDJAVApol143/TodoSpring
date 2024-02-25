package com.example.listazadanspring.repository;

import com.example.listazadanspring.model.TaskGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskGroupRepository {
    List<TaskGroup> findAllGroups();
    Optional<TaskGroup> findById(Long id);
    TaskGroup save(TaskGroup entity);

    boolean existsByDoneCheckIsFalseAndProject_Id(Long projectId);


}
