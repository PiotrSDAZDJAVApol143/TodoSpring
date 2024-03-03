package com.example.listazadanspring.service;

import com.example.listazadanspring.configuration.TaskConfiguration;
import com.example.listazadanspring.dto.GroupReadModel;
import com.example.listazadanspring.dto.ProjectWriteModel;
import com.example.listazadanspring.model.Project;
import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.model.TaskGroup;
import com.example.listazadanspring.repository.ProjectRepository;
import com.example.listazadanspring.repository.TaskGroupRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProjectService {
    private  ProjectRepository repository;
    private TaskGroupRepository taskGroupRepository;
    private TaskConfiguration config;

    public ProjectService(final ProjectRepository repository, final TaskGroupRepository taskGroupRepository, final TaskConfiguration config) {
        this.repository = repository;
        this.taskGroupRepository = taskGroupRepository;
        this.config = config;
    }

    public List<Project> readAll() {
        return repository.findAll();
    }

    public Project save(final Project toSave) {
        return repository.save(toSave);
    }

    public GroupReadModel createGroup(LocalDateTime deadline, Long projectId) {
        if (!config.getTemplate().isAllowMultipleTasks() && taskGroupRepository.existsByDoneCheckIsFalseAndProject_Id(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        TaskGroup result = repository.findById(projectId)
                .map(project -> {
                    var targetGroup = new TaskGroup();
                    targetGroup.setDescription(project.getDescription());
                    targetGroup.setTasks(
                            project.getSteps().stream()
                                    .map(projectStep -> new Task(
                                            projectStep.getDescription(),
                                            deadline.plusDays(projectStep.getDaysToDeadline()))
                                    ).collect(Collectors.toSet())
                    );
                    return targetGroup;
                }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
        return new GroupReadModel(result);
    }

    public Project save(final ProjectWriteModel toSave) {
        return repository.save(toSave.toProject());
    }
}
