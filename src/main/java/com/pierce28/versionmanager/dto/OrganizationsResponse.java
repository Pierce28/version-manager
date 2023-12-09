package com.pierce28.versionmanager.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrganizationsResponse {
    @NonNull
    private String name;
}