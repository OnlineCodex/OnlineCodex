package oc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class BuildaMenu extends JFrame implements BuildaSTK {

    private static final long serialVersionUID = 1L;
    public static final Font ARIAL = new Font("arial", Font.PLAIN, 14);
    private final JTextArea tMausradSpeed = new JTextArea(String.valueOf(DEFAULT_MAUSWHEELLSPEED));
    private final JTextArea tPfeiltastenSpeed = new JTextArea(String.valueOf(DEFAULT_PFEILTASTENSPEED));
    private final JCheckBox vertikalScrollen = new JCheckBox("", true);
    private final JCheckBox bildaz = new JCheckBox("", true);

    BuildaMenu() {
        super(BuildaHQ.translate("Einstellungen"));
        this.setLayout(null);
        this.setBounds(200, 200, 584, 320); // 404 210
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setIconImage(BuildaHQ.oCLogo);

        final int XX = 15;
        int cnt = 10;

        final JLabel lMausradSpeed = new JLabel(BuildaHQ.translate("Geschwindigkeit des Mausrads:"));
        lMausradSpeed.setBounds(XX, cnt, 190, 18);
        tMausradSpeed.setBounds(XX + 195, cnt + 2, 35, 18);
        cnt += 22;
        final JLabel lVertikalScrollen = new JLabel(BuildaHQ.translate("Scrollrichtung umdrehen"));
        lVertikalScrollen.setBounds(XX, cnt, 180, 18);
        vertikalScrollen.setBounds(XX + 195 - 3, cnt, 30, 18);
        cnt += 25;
        final JLabel lPfeiltastenSpeed = new JLabel(BuildaHQ.translate("Geschwindigkeit der Pfeiltasten:"));
        lPfeiltastenSpeed.setBounds(XX, cnt, 190, 18);
        tPfeiltastenSpeed.setBounds(XX + 195, cnt + 2, 35, 18);

        cnt += 25;

        String h1;
        h1 = BuildaHQ.translate("Hier kann man verändern, wie schnell mit dem Mausrad gescrollt wird");

        lMausradSpeed.setToolTipText(h1);
        tMausradSpeed.setToolTipText(h1);

        h1 = BuildaHQ.translate("Hier kann man verändern, wie schnell mit den Pfeiltasten gescrollt wird");

        lPfeiltastenSpeed.setToolTipText(h1);
        tPfeiltastenSpeed.setToolTipText(h1);

        tMausradSpeed.setFont(ARIAL);
        tPfeiltastenSpeed.setFont(ARIAL);
        final KeyListener closeKeyListener = new KeyListener() {
            @Override
			public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER || event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    closeBuildaMenu();
                }
            }

            @Override
			public void keyReleased(KeyEvent event) {
            }

            @Override
			public void keyTyped(KeyEvent event) {
            }
        };
        tMausradSpeed.addKeyListener(closeKeyListener);
        tPfeiltastenSpeed.addKeyListener(closeKeyListener);

        vertikalScrollen.setBackground(Color.WHITE);

        h1 = BuildaHQ.translate("<html>Dreht das scrollen mit dem Mausrad um. Normalerweise wird oben-unten, bei gedrückten STRG links-rechts gescrollt.<br>Wenn angehakt, wird links-rechts gescrollt, wenn STRG gedrückt ist, oben-unten.</html>");

        vertikalScrollen.setToolTipText(h1);
        lVertikalScrollen.setToolTipText(h1);

        h1 = BuildaHQ.translate("Hier kann man einstellen, ob Apokalypse-Einheiten ausgewählt werden können oder nicht.");

        cnt += 25;
        final JLabel lBildaz = new JLabel(BuildaHQ.translate("Bilder"));
        lBildaz.setBounds(XX, cnt, 180, 18);
        bildaz.setBounds(XX + 195 - 3, cnt, 30, 18);
        bildaz.setBackground(Color.WHITE);

        h1 = BuildaHQ.translate("Es werden keine Bilder angezeigt. Verkleinert manche Einträge.");
        bildaz.setToolTipText(h1);
        lBildaz.setToolTipText(h1);
        cnt += 31;

        this.add(lMausradSpeed);
        this.add(tMausradSpeed);
        this.add(lVertikalScrollen);
        this.add(vertikalScrollen);
        this.add(lPfeiltastenSpeed);
        this.add(tPfeiltastenSpeed);
        this.add(bildaz);
        this.add(lBildaz);

        final JButton ok = new JButton(BuildaHQ.translate("OK"));
        ok.setBounds(this.getSize().width - 90, this.getSize().height - 77, 76, 17);
        ok.setBorder(null);
        this.add(ok);
        this.getRootPane().setDefaultButton(ok);
        ok.addKeyListener(closeKeyListener);
        final ActionListener closeActionListener = event -> closeBuildaMenu();
        ok.addActionListener(closeActionListener);

        final JLabel ico = BuildaHQ.createPictureJLabel("oc/sysimages/smArtwork.gif"); // ACHTUNG BEI ÄNDERUNGEN AUCH IN BUILDAPANEL ANPASSEN!!!
        ico.setLocation(260, 12);
        this.add(ico);

        loadPrefs();

    }

    public void closeBuildaMenu() {
        this.setVisible(false);
    }

    public int getMausradSpeed() {
        try {
            return Integer.parseInt(tMausradSpeed.getText());
        } catch (final NumberFormatException e) {
            tMausradSpeed.setText(String.valueOf(DEFAULT_MAUSWHEELLSPEED));
            return DEFAULT_MAUSWHEELLSPEED;
        }

    }

    public int getPfeiltastenSpeed() {
        try {
            return Integer.parseInt(tPfeiltastenSpeed.getText());
        } catch (final NumberFormatException e) {
            tPfeiltastenSpeed.setText(String.valueOf(DEFAULT_PFEILTASTENSPEED));
            return DEFAULT_PFEILTASTENSPEED;
        }

    }

    public boolean isBildaz() {
        return bildaz.isSelected();

    }

    public boolean isVertikalScrolling() {
        return vertikalScrollen.isSelected();

    }

    public BuildaMenu getInstance() {
        return this;
    }

    public void savePrefs() {
        final Preferences prefs = OnlineCodex.getInstance().getPrefs();

        prefs.putBoolean(PREFERENCES_SHOW_PICTURES, isBildaz());
        prefs.putBoolean(PREFERENCES_SCROLL_VERTICAL, isVertikalScrolling());
        prefs.putInt(PREFERENCES_MOUSE_WHEEL_SPEED, getMausradSpeed());
        prefs.putInt(PREFERENCES_ARROW_KEYS_SPEED, getPfeiltastenSpeed());
    }

    public void loadPrefs() {
        final Preferences prefs = OnlineCodex.getInstance().getPrefs();
        bildaz.setSelected(prefs.getBoolean(PREFERENCES_SHOW_PICTURES, isBildaz()));
        vertikalScrollen.setSelected(prefs.getBoolean(PREFERENCES_SCROLL_VERTICAL, isVertikalScrolling()));
        tMausradSpeed.setText(Integer.toString(prefs.getInt(PREFERENCES_MOUSE_WHEEL_SPEED, getMausradSpeed())));
        tPfeiltastenSpeed.setText(Integer.toString(prefs.getInt(PREFERENCES_ARROW_KEYS_SPEED, getPfeiltastenSpeed())));
    }

}