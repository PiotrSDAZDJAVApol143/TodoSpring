package com.example.listazadanspring.controller;

import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.model.TaskRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepo;

    public TaskController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }
    @GetMapping(value = "/tasks", params = {"!sort","!page", "!size"})
    ResponseEntity<List<Task>>readAllTasks(){
        logger.warn("Exposing all the Tasks");
        return ResponseEntity.ok(taskRepo.findAll());
    }

    @GetMapping(value = "/tasks")
    ResponseEntity<List<Task>>readAllTasks(Pageable page){
        logger.info("custom pageable");
        return ResponseEntity.ok(taskRepo.findAll(page).getContent());
    }
    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTasks(@PathVariable int id,@RequestBody @Valid Task toUpdate){
        if(!taskRepo.existById(id)){
            return  ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        taskRepo.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
