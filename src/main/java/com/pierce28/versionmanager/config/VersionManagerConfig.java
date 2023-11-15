package com.pierce28.versionmanager.config;

import com.pierce28.versionmanager.service.AppService;
import com.pierce28.versionmanager.service.OrganizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VersionManagerConfig {

    @Bean
    public AppService appService(VersionManagerProperties applicationProperties) {
        return new AppService(applicationProperties);
    }
    
    @Bean
    public OrganizationService organizationService(VersionManagerProperties applicationProperties) {
        return new OrganizationService(applicationProperties);
    }
}