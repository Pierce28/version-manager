package com.pierce28.versionmanager.model;

import lombok.Data;

import java.util.List;

@Data
public class Organization {

    private String name;
    private List<Application> applications;
}