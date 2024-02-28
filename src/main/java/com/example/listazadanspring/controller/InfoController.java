package com.example.listazadanspring.controller;

import com.example.listazadanspring.configuration.TaskConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/info")
public class InfoController {
    private DataSourceProperties dataSourceProperties;
    private TaskConfiguration taskConfiguration;

    @GetMapping("/url")
    String url() {
        return taskConfiguration.getUrl();
    }

    @GetMapping("/prop")
    boolean myProp() {
        return taskConfiguration.getTemplate().isAllowMultipleTasks();
    }
}