package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.ApplicationProperties;
import com.pierce28.versionmanager.model.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
public class GitService {
    
    private final ApplicationProperties applicationProperties;
    
    public String getDiffs(String appName, String sourceEnv, String targetEnv) {
        List<Application> applications = applicationProperties.getApplications();

        Application application = applications.stream()
            .filter(app -> appName.equals(app.getName()))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        // TODO - actually do the git magic
        
        return String.format("App [%s] Source Environment [%s] Target Environment [%s]", appName, sourceEnv, targetEnv);
    }
}