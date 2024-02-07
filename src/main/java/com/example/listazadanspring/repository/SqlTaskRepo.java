package com.example.listazadanspring.repository;

import com.example.listazadanspring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskRepo extends TaskRepository, JpaRepository<Task, Integer> {

}
