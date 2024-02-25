package com.example.listazadanspring;

import com.example.listazadanspring.model.Task;
import com.example.listazadanspring.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

@Configuration
public class TestConfiguration {
    @Bean
    @Profile("integration")
    TaskRepository testRepo() {
        return new TaskRepository() {

            private Map<Integer, Task> tasks = new HashMap<>();

            @Override
            public List<Task> findAll() {
                return new ArrayList<>(tasks.values());
            }

            @Override
            public Optional<Task> findById(Long id) {
                return Optional.ofNullable(tasks.get(id));
            }

            @Override
            public Task save(Task entity) {
                return tasks.put(tasks.size() + 1, entity);
            }

            @Override
            public Page<Task> findAll(Pageable page) {
                return null;
            }

            @Override
            public List<Task> findByDoneCheck(boolean doneCheck) {
                return null;
            }

            @Override
            public boolean existsById(Long id) {
                return tasks.containsKey(id);
            }

            @Override
            public boolean existsByDoneCheckIsFalseAndId(Long id) {
                return false;
            }

        };

    }
}
