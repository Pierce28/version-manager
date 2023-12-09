package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.config.VersionManagerProperties;
import com.pierce28.versionmanager.dto.Application;
import com.pierce28.versionmanager.dto.ApplicationsResponse;
import com.pierce28.versionmanager.config.model.ApplicationConfig;
import com.pierce28.versionmanager.config.model.EnvironmentConfig;
import com.pierce28.versionmanager.config.model.OrganizationConfig;
import com.pierce28.versionmanager.dto.Environment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AppService {

    private final VersionManagerProperties versionManagerProperties;
    private final WebClient webClient;

    public ApplicationsResponse getApplicationsForOrganization(String organizationName) {
        OrganizationConfig organizationConfig = versionManagerProperties.getOrganizations().stream()
                .filter(org -> organizationName.equals(org.getName()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<ApplicationConfig> applicationConfigs = organizationConfig.getApplications();
        List<Application> applications = new ArrayList<>();

        applicationConfigs.forEach(applicationConfig -> applications.add(createApplication(applicationConfig)));

        return ApplicationsResponse.builder()
                .organization(organizationConfig.getName())
                .applications(applications)
                .build();
    }

    private Environment createEnvironemnt(EnvironmentConfig environmentConfig) {
        return Environment.builder()
                .name(environmentConfig.getName())
                .logs(environmentConfig.getLogs())
                .jenkins(environmentConfig.getJenkins())
                .version(getEndpointData(environmentConfig.getVersionEndpoint()))
                .gitCommitHash(getEndpointData(environmentConfig.getGitEndpoint()))
                .build();
    }

    private Application createApplication(ApplicationConfig applicationConfig) {
        Application application = new Application();

        application.setName(applicationConfig.getName());
        application.setOwner(applicationConfig.getOwner());
        application.setRepo(applicationConfig.getRepo());

        List<Environment> environments = new ArrayList<>();

        applicationConfig.getEnvironments().forEach(environmentConfig -> environments.add(createEnvironemnt(environmentConfig)));

        application.setEnvironments(environments);

        return application;
    }

    private String getEndpointData(String endpoint) {
        if (endpoint == null || endpoint.isEmpty()) {
            return "N/A";
        }

        return webClient
                .get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}