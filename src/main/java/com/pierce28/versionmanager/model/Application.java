package com.pierce28.versionmanager.model;

import lombok.Data;

import java.util.List;

@Data
public class Application {

    private String name;
    private String owner;
    private String repo;
    private List<Environment> environments;
}