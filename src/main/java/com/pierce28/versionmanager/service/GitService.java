package com.pierce28.versionmanager.service;

import com.pierce28.versionmanager.model.Application;
import com.pierce28.versionmanager.model.GitDiff;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GitService {

    public GitDiff getDiffs(Application application, String sourceEnv, String targetEnv) {

        // TODO - actually do the git magic
        return GitDiff.builder()
                .placeholder("test string; please ignore")
                .build();
    }
}