package com.example.listazadanspring.adapter;

import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.repository.TaskRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
interface SqlTaskRepo extends TaskRepository, JpaRepository<Task, Long> {
    @Override
    @Query(nativeQuery = true, value = "select count(*)>0 from tasks where id=:id")
    boolean existsById(@Param("id") Long id);

    @Override
    boolean existsByDoneCheckIsFalseAndId(Long id);

    @Override
    List<Task> findAllByTaskGroup_Id(Long groupId);
}
