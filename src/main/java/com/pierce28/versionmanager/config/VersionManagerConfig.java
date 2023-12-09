package com.pierce28.versionmanager.config;

import com.pierce28.versionmanager.service.AppService;
import com.pierce28.versionmanager.service.OrganizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class VersionManagerConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    @Bean
    public AppService appService(VersionManagerProperties applicationProperties, WebClient webClient) {
        return new AppService(applicationProperties, webClient);
    }

    @Bean
    public OrganizationService organizationService(VersionManagerProperties applicationProperties) {
        return new OrganizationService(applicationProperties);
    }
}