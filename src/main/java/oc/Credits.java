package oc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Credits extends JFrame {


    private static final long serialVersionUID = 1L;

    public Credits() {
        super(BuildaHQ.translate("Credits"));
        this.setLayout(new BorderLayout());
        this.setBounds(200, 200, 640, 480); // 404 210
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setIconImage(BuildaHQ.oCLogo);
        setLocationRelativeTo(OnlineCodex.getInstance().getBuildaPanel());

        final JLabel title = new JLabel("OnlineCodex - Powered by OnlineCodex.de", SwingConstants.CENTER);
        final JLabel footer = new JLabel("www.onlinecodex.de", SwingConstants.CENTER);

        final JPanel north = new JPanel(new FlowLayout());
        north.add(title);
        final JPanel south = new JPanel(new FlowLayout());
        south.add(footer);
        final JPanel east = new JPanel(new FlowLayout());
        east.add(new JLabel("     "));
        final JPanel west = new JPanel(new FlowLayout());
        west.add(new JLabel("     "));

        final JTextArea txaInfo = new JTextArea(10, 40);
        txaInfo.setText(
                "OnlineCodex ist ein Open Source Projekt - Copyright (c) 2009-2017 OnlineCodex.de\n" +
                        "Die Projektzentrale ist unsere Webseite: www.onlinecodex.de\n\n" +
                        "DIESES SOFTWARE-PROJEKT IST VOLLKOMMEN INOFFIZIELL UND IN KEINER WEISE VON " +
                        "GAMES WORKSHOP LIMITED UNTERSTÜTZT. ES WERDEN WARENZEICHEN VON GAMES " +
                        "WORKSHOP LIMITED VERWENDET. HINWEISE HIERZU BEFINDEN SICH IN ABSCHNITT " +
                        "(3) DIESES TEXTES." +
                        "\n\n\n" +
                        "1) PROGRAMMIERUNG\n" +
                        "===================" +
                        "\n\n" +
                        "- Stefan \"Odysseus\" Oswald\n" +
                        "- Jan \"Spacecooky\" Koch\n" +
			"- Philipp \"chisui\" Dargel\n" +
                        "- Graham \"Lamekh\" Page (bis April 2013)\n" +
                        "- Florian \"Sanguinus\" Cramer (bis Januar 2013)\n" +
                        "- Matthias \"Schandro\" Kalla (bis Februar 2009)\n" +
                        "\n\n" +
                        "Beiträge zur Programmierung:\n" +
                        "- Christoph Hoffmann (Gruftkönige)\n" +
                        "- Peter \"TooN\" Pietrzyk (Echsenmenschen)\n" +
                        "- Alexander Serowy (Gnoblars)\n" +
                        "- \"Imunar\"\n" +
                        "- \"Zorg\" (CSM, DA, CD, TAU)" +
                        "\n\n\n" +
                        "2) BILDNACHWEIS\n" +
                        "===============" +
                        "\n\n" +
                        "Miniaturen Copyright (c) Games Workshop Ltd. Verwendet ohne Erlaubnis." +
                        "\n\n" +
                        "> Black Templar\nBemalt von: \"Dante\"\n\n" +
                        "> Blood Angels\nBemalt von: Michael Töpfer, Stefan Oswald\n\n" +
                        "> Eldar\nBemalt von: Thomas Draheim, Frederic Eysell\n\n" +
                        "> Space Wolves\nBemalt von: Norman Rieß\n\n" +
                        "> Tyraniden\nBemalt von: Stefan Oswald" +
                        "\n\n\n" +
                        "3) WARENZEICHEN VON GAMES WORKSHOP\n" +
                        "=====================================" +
                        "\n\n" +
                        "Adeptus Astartes, Raumflotte Gothic, Black Flame, Black Library, das Black-Library-Logo, BL Publishing, Blood Angels, Bloodquest, Blood Bowl, das Blood-Bowl-Logo, das Blood-Bowl-Stachel-Emblem, Cadianer, Catachaner, das Chaos-Emblem, Straßenkampf, das Chaos-Logo, Citadel, das Citadel-Emblem, Stadt der Verdammten, Codex, Dämonenjäger, Dark Angels, Dark Eldar, Dark Future, das Emblem des doppelköpfigen Imperialen Adlers, 'Eavy Metal, Eldar, die Eldar-Symbole, Epic, Occularis Terribus, das Auge des Schreckens, Fanatic, das Fanatic-Logo, das Fanatic-II-Logo, Fire Warrior, Feuerkrieger, Forge World, Games Workshop, das Games-Workshop-Logo, Symbiont, Golden Demon, Gorkamorka, der Große Verpester, das Hammer-des-Sigmar-Logo, das Gehörnte-Ratte-Logo, Inferno, Inquisitor, das Inquisitor-Logo, das Inquisitor-Emblem, Inquisitor:Conspiracies, Hüter der Geheimnisse, Khemri, Khorne, das Khorne-Logo, Kroot, Herrscher des Wandels, Marauder, Chaosbarbar, Mordheim, Mortheim, das Mordheim-Logo, das Mortheim-Logo, Necromunda, das Necromunda-Schablonen-Logo, das Necromunda-Plattenlogo, Necron, Nurgle, das Nurgle-Logo, Ork, die Ork-Schädelsymbole, Sisters of Battle, Sororitas, Skaven, die Skaven-Symbole, Slaanesh, das Slaanesh-Logo, Space Hulk, Space Marine, Space-Marine-Orden, Space-Marine-Ordenslogos, Talisman, Tau, die Tau-Kastenbezeichnungen, Gruftkönige, Trio of Warriors, das Logo des zweischweifigen Kometen, Tyranid, Tyrannid, Tzeentch, das Tzeentch-Logo, Ultramarines, Warhammer, Warhammer Historical, Warhammer Online, das Warhammer-40.000-Emblem, das Warhammer-World-Logo, Warmaster, White Dwarf, das White-Dwarf-Logo und alle assoziierten Kennzeichenrechte (TM), Namen, Völker, Völker-Zeichen, Charaktere, Kreaturen, Fahrzeuge, Orte, Einheiten, Illustrationen und Bilder aus dem Blood-Bowl-Spiel, der Warhammer-Welt, der Talisman-Welt und dem Warhammer-40.000-Universum, sind entweder Ž, Kennzeichenrechte (TM) und/oder Š Copyright Games Workshop Ltd 2000-2009, wenn zutreffend im Vereinigten Königreich und anderen Ländern der Welt eingetragen. Benutzung ohne Genehmigung. Keine Anfechtung ihres Status. Alle Rechte liegen bei den entsprechenden Besitzern." +
                        "\n\n"
        );
        txaInfo.setCaretPosition(0);
        txaInfo.setEditable(false);
        txaInfo.setLineWrap(true);
        txaInfo.setWrapStyleWord(true);

        final JScrollPane sp = new JScrollPane(txaInfo);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(BorderLayout.CENTER, sp);
        add(BorderLayout.NORTH, north);
        add(BorderLayout.EAST, east);
        add(BorderLayout.WEST, west);
        add(BorderLayout.SOUTH, south);
    }

    public void closeBuildaMenu() {
        this.setVisible(false);
    }

    public Credits getInstance() {
        return this;
    }

}

