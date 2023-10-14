package com.pierce28.versionmanager.config;

import com.pierce28.versionmanager.service.AppService;
import com.pierce28.versionmanager.service.GitService;
import com.pierce28.versionmanager.service.VersionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VersionManagerConfig {

    @Bean
    public AppService appService(ApplicationProperties applicationProperties) {
        return new AppService(applicationProperties);
    }
    
    @Bean
    public VersionService versionService(ApplicationProperties applicationProperties) {
        return new VersionService(applicationProperties);
    }
    
    @Bean
    public GitService gitService(ApplicationProperties applicationProperties) {
        return new GitService(applicationProperties);
    }
}