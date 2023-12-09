package com.pierce28.versionmanager.config.model;

import lombok.Data;

import java.util.List;

@Data
public class OrganizationConfig {

    private String name;
    private List<ApplicationConfig> applications;
}