package com.pierce28.versionmanager.model;

import lombok.Data;

@Data
public class Environment {

    private String name;
    private String logs;
    private String jenkins;
    private String versionEndpoint;
    private String gitEndpoint;
}