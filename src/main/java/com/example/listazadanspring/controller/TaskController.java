package com.example.listazadanspring.controller;

import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.repository.TaskRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepo;

    public TaskController(final TaskRepository taskRepo) {

        this.taskRepo = taskRepo;
    }

    @PostMapping("/add")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task toCreate) {
        Task result = taskRepo.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping(value = "/all", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(taskRepo.findAll());
    }

    @GetMapping("/all")
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(taskRepo.findAll(page).getContent());
    }

    @GetMapping("/showTask/{id}")
    ResponseEntity<Task> readTask(@PathVariable Long id) {
        return taskRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/done")
    ResponseEntity<List<Task>> searchDoneTasks(@RequestParam(defaultValue = "true") boolean state){
        return ResponseEntity.ok(
                taskRepo.findByDoneCheck(state)
        );
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody @Valid Task toUpdate) {
        if (!taskRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepo.findById(id)
                .ifPresent(task -> {
                    task.updateFrom(toUpdate);
                    taskRepo.save(task);
                });
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/toggle/{id}")
    public ResponseEntity<?> toggleTask(@PathVariable Long id) {
        if (!taskRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepo.findById(id)
                .ifPresent(task -> task.setDoneCheck(!task.isDoneCheck()));
        return ResponseEntity.noContent().build();
    }


}
