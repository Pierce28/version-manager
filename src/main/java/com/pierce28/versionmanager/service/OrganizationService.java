package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.VersionManagerProperties;
import com.pierce28.versionmanager.dto.OrganizationsResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrganizationService {
    private final VersionManagerProperties versionManagerProperties;

    public List<OrganizationsResponse> getOrganizations() {
        return versionManagerProperties.getOrganizations().stream()
                .map(organization -> new OrganizationsResponse(organization.getName()))
                .collect(Collectors.toList());
    }
}