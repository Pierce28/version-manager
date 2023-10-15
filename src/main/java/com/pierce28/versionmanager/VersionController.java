package com.pierce28.versionmanager;

import com.pierce28.versionmanager.model.AppVersionDetail;
import com.pierce28.versionmanager.model.Application;
import com.pierce28.versionmanager.model.GitDiff;
import com.pierce28.versionmanager.service.AppService;
import com.pierce28.versionmanager.service.GitService;
import com.pierce28.versionmanager.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VersionController {
    
    private final AppService appService;
    private final VersionService versionService;
    private final GitService gitService;

    @GetMapping("/org/{org}")
    public List<Application> getApplicationsForOrg(@PathVariable String org) {
        return appService.getApplicationsForOrganization(org);
    }

    @GetMapping("/org/{org}/app/{app}")
    public List<AppVersionDetail> getAppVersions(@PathVariable String org, @PathVariable String app) {
        Application application = appService.getApplicationByOrgAndName(org, app);
        return versionService.getVersionsForApp(application);
    }

    @GetMapping("/org/{org}/app/{app}/sourceEnv/{sourceEnv}/targetEnv/{targetEnv}")
    public GitDiff getGitDiffs(@PathVariable String org, @PathVariable String app, @PathVariable String sourceEnv, @PathVariable String targetEnv) {
        Application application = appService.getApplicationByOrgAndName(org, app);

        return gitService.getDiffs(application, sourceEnv,targetEnv);
    }
}