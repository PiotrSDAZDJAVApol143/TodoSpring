package com.example.listazadanspring.controller;

import com.example.listazadanspring.dto.GroupReadModel;
import com.example.listazadanspring.dto.GroupWriteModel;
import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.repository.TaskRepository;
import com.example.listazadanspring.service.TaskGroupService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class TaskGroupController {
    private static final Logger logger = LoggerFactory.getLogger(TaskGroupController.class);
    private final TaskGroupService taskGroupService;
    private final TaskRepository taskRepo;

    public TaskGroupController(TaskGroupService taskGroupService, final TaskRepository taskRepo) {
        this.taskGroupService = taskGroupService;

        this.taskRepo = taskRepo;

    }

    @PostMapping("/add")
    ResponseEntity<GroupReadModel> createGroup(@RequestBody @Valid GroupWriteModel toCreate) {
        GroupReadModel result = taskGroupService.createGroup(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<GroupReadModel>> readAllGroups() {
        return ResponseEntity.ok(taskGroupService.readAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Task>> readAllTaskFromGroup(@PathVariable Long id) {
        return ResponseEntity.ok(taskRepo.findAllByTaskGroup_Id(id));
    }

    @Transactional
    @PatchMapping("/toggle/{id}")
    public ResponseEntity<?> toggleGroup(@PathVariable Long id) {
        taskGroupService.toggleGroup(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalState(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
