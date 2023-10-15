package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.VersionManagerProperties;
import com.pierce28.versionmanager.model.Application;
import com.pierce28.versionmanager.model.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
public class AppService {

    private final VersionManagerProperties versionManagerProperties;

    public List<Application> getApplicationsForOrganization(String organizationName) {
        Organization organization = versionManagerProperties.getOrganizations().stream()
            .filter(org -> organizationName.equals(org.getName()))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        return organization.getApplications();
    }

    public Application getApplicationByOrgAndName(String organizationName, String applicationName) {
        List<Application> apps = getApplicationsForOrganization(organizationName);

        return apps.stream()
            .filter(application -> applicationName.equals(application.getName()))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}