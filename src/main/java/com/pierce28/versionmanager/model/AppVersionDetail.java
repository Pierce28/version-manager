package com.pierce28.versionmanager.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppVersionDetail {

    private String environment;
    private String version;
}