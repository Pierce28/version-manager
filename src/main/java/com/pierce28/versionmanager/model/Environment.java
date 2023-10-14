package com.pierce28.versionmanager.model;

import lombok.Data;

@Data
public class Environment {

    private String name;
    private String versionEndpoint;
    private String gitEndpoint;
}