package com.example.listazadanspring.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties("task")
public class TaskConfiguration {
    private Template template;
    @Getter
    private String url;

    @Setter
    @Getter
    public static class Template {
        private boolean allowMultipleTasks;

    }
}
