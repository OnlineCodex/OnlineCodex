package oc;

import com.github.zafarkhaja.semver.Version;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import oc.utils.DesktopUtils;
import oc.utils.GitHubUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.text.MessageFormat;

public final class VersionChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(VersionChecker.class);

    private static final String LATETEST_RELEASE_URL = "https://github.com/OnlineCodex/OnlineCodex/releases/latest";
    private static final Table<Sprache, String, String> TRANSLATIONS = ImmutableTable.<Sprache, String, String>builder()
            .put(Sprache.English, "version.dialog.title", "New Version available")
            .put(Sprache.German, "version.dialog.title", "Neue Version verfügbar")
            .put(Sprache.English, "version.dialog.content",
                    "<html>" +
                            "<h1>An update for the OnlineCodex is available</h1>" +
                            "<p>To download the update click <a href=\"{0}\">here</a>." +
                            "</html>")
            .put(Sprache.German, "version.dialog.content",
                    "<html>" +
                            "<h1>Eine neue Version des OnlineCodex ist verfügbar</h1>" +
                            "<p>Um diese herunter zu laden, klicken sie <a href=\"{0}\">hier</a>." +
                            "</html>")
            .put(Sprache.English, "version.dialog.ok", "OK")
            .put(Sprache.German, "version.dialog.ok", "OK")
            .build();

    public static void execute(Version currentVersion) {
        new Thread(() -> {
            GitHubUtils.getLatestReleaseVersion()
                    .filter(currentVersion::lessThan)
                    .ifPresent(releaseVersion -> showVersionPopup(BuildaHQ.getSprache(), currentVersion, releaseVersion));
        }).start();
    }

    private static void showVersionPopup(Sprache lang, Version currentVersion, Version releaseVersion) {
        LOGGER.info("Found newer version. current: " + currentVersion + " latest: " + releaseVersion);
        createVersionMessageBox(lang, currentVersion, releaseVersion)
                .setVisible(true);
    }

    private static JDialog createVersionMessageBox(Sprache lang, Version currentVersion, Version releaseVersion) {
        JDialog d = new JDialog((Frame) null, translate(lang, "version.dialog.title"), true);
        d.setLocationRelativeTo(null);
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        d.setContentPane(p);
        p.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        p.add(createHTMLPane(
                translate(lang, "version.dialog.content", LATETEST_RELEASE_URL, currentVersion, releaseVersion),
                d::dispose));
        p.add(Box.createHorizontalGlue());
        p.add(createOKButton(lang, d::dispose));
        d.pack();
        return d;
    }

    private static JButton createOKButton(Sprache lang, Runnable callback) {
        JButton b = new JButton(translate(lang, "version.dialog.ok"));
        b.addActionListener(event -> callback.run());
        return b;
    }

    private static JEditorPane createHTMLPane(String text, Runnable callback) {
        JEditorPane content = new JEditorPane();
        content.setEditable(false);
        content.setEditorKit(new HTMLEditorKit());
        content.setText(text);
        content.addHyperlinkListener(event -> openURL(callback, event));
        return content;
    }

    private static void openURL(Runnable callback, HyperlinkEvent event) {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            DesktopUtils.openLink(event.getURL().toString());
            callback.run();
        }
    }

    private static String translate(Sprache lang, String key, Object... args) {
        return MessageFormat.format(TRANSLATIONS.get(lang, key), args);
    }

}
