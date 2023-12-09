package com.pierce28.versionmanager;

import com.pierce28.versionmanager.dto.ApplicationsResponse;
import com.pierce28.versionmanager.dto.OrganizationsResponse;
import com.pierce28.versionmanager.service.AppService;
import com.pierce28.versionmanager.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VersionController {

    private final AppService appService;
    private final OrganizationService organizationService;

    @GetMapping("/orgs")
    public List<OrganizationsResponse> getOrganizations() {
        return organizationService.getOrganizations();
    }

    @GetMapping("/org/{org}")
    public ApplicationsResponse getApplicationsForOrg(@PathVariable String org) {
        return appService.getApplicationsForOrganization(org);
    }

    @GetMapping("/version")
    public String getTestVersion() {
        return "42";
    }

    @GetMapping("/commitHash")
    public String getTestCommitHash() {
        return "hashbrowns";
    }
}