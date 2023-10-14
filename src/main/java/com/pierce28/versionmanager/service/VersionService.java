package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.ApplicationProperties;
import com.pierce28.versionmanager.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
public class VersionService {
    
    private final ApplicationProperties applicationProperties;

    public String getVersionsForApp(String appName) {
        List<Application> applications = applicationProperties.getApplications();
        
        Application application = applications.stream()
            .filter(app -> appName.equals(app.getName()))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // TODO - call endpoint, return version. Abstract this as it can be shared with GitService
        
        return application.toString();
    }
}