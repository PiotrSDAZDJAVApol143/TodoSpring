package com.example.listazadanspring.repository;

import com.example.listazadanspring.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(Integer id);
    Task save(Task entity);
    Page<Task> findAll(Pageable page);
    List<Task> findByDoneCheck(boolean doneCheck);
    boolean existsById(Integer id);
    boolean existsByDoneCheckIsFalseAndId(Integer id);

}
