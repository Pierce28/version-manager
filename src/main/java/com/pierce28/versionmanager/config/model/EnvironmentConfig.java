package com.pierce28.versionmanager.config.model;

import lombok.Data;

@Data
public class EnvironmentConfig {

    private String name;
    private String logs;
    private String jenkins;
    private String versionEndpoint;
    private String gitEndpoint;
}