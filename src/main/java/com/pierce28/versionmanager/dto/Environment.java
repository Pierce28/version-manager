package com.pierce28.versionmanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Environment {

    private String name;
    private String logs;
    private String jenkins;
    private String version;
    private String gitCommitHash;
}