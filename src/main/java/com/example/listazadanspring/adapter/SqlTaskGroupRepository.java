package com.example.listazadanspring.adapter;

import com.example.listazadanspring.model.TaskGroup;
import com.example.listazadanspring.repository.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {
@Override
    @Query("select distinct g from TaskGroup g join fetch g.taskList")
// zwrocone wyniki querry powinny być unikalne
List<TaskGroup> findAllGroups();
}
