package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.VersionManagerProperties;
import com.pierce28.versionmanager.dto.ApplicationsResponse;
import com.pierce28.versionmanager.model.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public class AppService {

    private final VersionManagerProperties versionManagerProperties;

    public ApplicationsResponse getApplicationsForOrganization(String organizationName) {
        Organization organization = versionManagerProperties.getOrganizations().stream()
            .filter(org -> organizationName.equals(org.getName()))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ApplicationsResponse.builder()
            .organization(organization.getName())
            .applications(organization.getApplications())
            .build();
    }
}