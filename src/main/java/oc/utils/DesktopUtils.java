package oc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.net.URI;

/**
 * Utilities for interacting with real desktop environments.
 */
public final class DesktopUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DesktopUtils.class);

    private DesktopUtils() {}

    public static void openLink(String uri) {
        try {
            if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(uri));
            } else {
                Runtime.getRuntime()
                        .exec(toOpenURLCmd(uri))
                        .waitFor();
            }
        } catch (Exception e) {
            LOGGER.error("", e);
        }
    }

    private static String[] toOpenURLCmd(String uri) {
        switch (getOs()) {
            case WIN:
                return new String[]{"rundll32 url.dll,FileProtocolHandler " + uri};
            case MAC:
                return new String[]{"open", uri};
            case NIX:
                return new String[]{"xdg-open", uri};
            default:
                throw new IllegalStateException("unsupported OS: " + getOs());
        }
    }

    public static OS getOs() {
        String osName = System.getProperty("os.name");
        if (osName.contains("win")) {
            return OS.WIN;
        } else if (osName.contains("mac") || osName.contains("darwin")) {
            return OS.MAC;
        } else {
            return OS.NIX;
        }
    }

    public enum OS {
        WIN, MAC, NIX
    }

}
