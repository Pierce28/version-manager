package com.pierce28.versionmanager.dto;

import com.pierce28.versionmanager.model.Application;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApplicationsResponse {
    private String organization;
    private List<Application> applications;
}