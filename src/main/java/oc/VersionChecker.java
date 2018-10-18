package oc;

import com.github.zafarkhaja.semver.Version;
import oc.utils.GitHubUtils;

import java.util.Optional;

public final class VersionChecker {

    public static void execute(Version currentVersion) {
        new Thread(() -> {
            GitHubUtils.getLatestReleaseVersion()
                    .filter(currentVersion::greaterThanOrEqualTo)
                    .ifPresent(releaseVersion -> showVersionPopup(currentVersion, releaseVersion));
        });
    }

    private static void showVersionPopup(Version currentVersion, Version releaseVersion) {

    }
}
