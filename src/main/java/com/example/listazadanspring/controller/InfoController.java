package com.example.listazadanspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.RestController;

@RestController("/info")
public class InfoController {
    @Autowired
    private DataSourceProperties dataSourceProperties;
@Value("${task.allowMultipleTasksFromTemplate")
    private String myProp;
}
