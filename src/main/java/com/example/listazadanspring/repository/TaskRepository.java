package com.example.listazadanspring.repository;

import com.example.listazadanspring.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task entity);
    Page<Task> findAll(Pageable page);
    List<Task> findByDoneCheck(boolean doneCheck);
    boolean existsById(Long id);
    boolean existsByDoneCheckIsFalseAndId(Long id);

}
