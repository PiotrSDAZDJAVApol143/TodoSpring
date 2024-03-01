package com.example.listazadanspring.service;

import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Async
    //filtrowanie asynchroniczne
    public CompletableFuture<List<Task>> findAllAsync(){
        logger.info("Supply Async");
        return CompletableFuture.supplyAsync(taskRepository::findAll);

    }


}
