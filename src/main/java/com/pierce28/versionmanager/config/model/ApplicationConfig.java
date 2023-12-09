package com.pierce28.versionmanager.config.model;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationConfig {

    private String name;
    private String owner;
    private String repo;
    private List<EnvironmentConfig> environments;
}