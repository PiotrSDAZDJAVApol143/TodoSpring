package com.example.listazadanspring.controller;

import com.example.listazadanspring.configuration.TaskConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController("/info")
public class InfoController {
    private DataSourceProperties dataSourceProperties;
    private TaskConfiguration taskConfiguration;
    boolean taskConfiguration(){
        return taskConfiguration.isAllowMultipleTasksFromTemplate();
    }
}
