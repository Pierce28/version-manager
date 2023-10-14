package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.ApplicationProperties;
import com.pierce28.versionmanager.model.Application;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AppService {

    private final ApplicationProperties applicationProperties;

    public List<String> getApps() {
        return applicationProperties.getApplications().stream()
            .map(Application::getName)
            .collect(Collectors.toList());
    }
}