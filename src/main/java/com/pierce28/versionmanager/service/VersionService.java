package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.model.AppVersionDetail;
import com.pierce28.versionmanager.model.Application;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class VersionService {

    public List<AppVersionDetail> getVersionsForApp(Application application) {
        List<AppVersionDetail> appVersionDetails = new ArrayList<>();

        application.getEnvironments().forEach(environment -> {
            // TODO - actually fetch the version using the version endpoint
            String version = "42.0";

            appVersionDetails.add(
                    AppVersionDetail.builder()
                            .environment(environment.getName())
                            .version(version)
                            .build()
            );
        });

        return appVersionDetails;
    }
}