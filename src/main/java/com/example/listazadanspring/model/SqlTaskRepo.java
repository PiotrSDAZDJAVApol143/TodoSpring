package com.example.listazadanspring.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SqlTaskRepo extends TaskRepository, JpaRepository<Task, Integer> {

}
