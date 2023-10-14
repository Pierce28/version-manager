package com.pierce28.versionmanager;

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

    @GetMapping("/apps")
    public List<String> getApps() {
        return appService.getApps();
    }
    
    @GetMapping("/app/{app}")
    public String getAppVersions(@PathVariable String app) {
        return versionService.getVersionsForApp(app);
    }
    
    @GetMapping("/app/{app}/sourceEnv/{sourceEnv}/targetEnv/{targetEnv}")
    public String getGitDiffs(@PathVariable String app, @PathVariable String sourceEnv, @PathVariable String targetEnv) {
        return gitService.getDiffs(app, sourceEnv,targetEnv);
    }
}