package com.pierce28.versionmanager.config;

import com.pierce28.versionmanager.model.Organization;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "version-manager")
@Data
public class VersionManagerProperties {

    private List<Organization> organizations;
}