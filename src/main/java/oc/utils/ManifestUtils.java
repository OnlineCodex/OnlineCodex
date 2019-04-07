package oc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.function.Function;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import com.github.zafarkhaja.semver.Version;

import oc.OnlineCodex;

/**
 * Utilities class to interact with jar manifest entries.
 */
public final class ManifestUtils {

    public static final String MANIFEST_VERSION = "Implementation-Version";
    private static final String MANIFEST_PATH = "/META-INF/MANIFEST.MF";

    private ManifestUtils() {
    }

    public static Optional<Version> getVersion() {
        return getVersion(OnlineCodex.class);
    }

    public static Optional<Version> getVersion(Class<?> cls) {
        return fromManifestEntries(cls,
                attrs -> Version.valueOf(attrs.getValue(MANIFEST_VERSION))
        );
    }

    public static <T> Optional<T> fromManifestEntries(Class<?> cls, Function<? super Attributes, T> f) {
        final String clsPath = cls.getResource(cls.getSimpleName() + ".class").toString();
        final String manifestPath = clsPath.substring(0, clsPath.lastIndexOf('!') + 1) + MANIFEST_PATH;
        try (InputStream in = new URL(manifestPath).openStream()) {
            return Optional.of(new Manifest(in).getMainAttributes())
                    .map(f);
        } catch (final IOException e) {
            return Optional.empty();
        }
    }
}
