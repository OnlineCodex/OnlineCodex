package oc.utils;

import java.util.Optional;

import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GitHub;

import com.github.zafarkhaja.semver.Version;

/**
 * Utils to access Data from Github.
 */
public final class GitHubUtils {

    private GitHubUtils() {
    }

    /**
     * Fetch the latest release version from github synchronously
     *
     * @return the latest release version or empty if an error occurred.
     */
    public static Optional<Version> getLatestReleaseVersion() {
        try {
            final GHRelease release = GitHub.connectAnonymously()
                    .getOrganization("OnlineCodex")
                    .getRepository("OnlineCodex")
                    .getLatestRelease();
            final String versionString = release.getTagName().substring(1);// strip "v" from version string
            return Optional.of(Version.valueOf(versionString));
        } catch (final Exception e) {
            return Optional.empty();
        }
    }
}
