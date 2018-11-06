package oc;

import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class AnzahlPanel extends OptionsVater implements KeyListener {

    private int minModelle;
    private int maxModelle;
    private int modelle = -1;
    private double preis;
    private double grundkosten = 0;
    private boolean controlled;
    private boolean legal = true;
    private boolean nichtDieErsteOption;
    private boolean zeilenumbruchZuvor = false;
    private boolean abschaltbar;
    private String name;
    private String kurzerName = null;
    private String langerName = null;
    private String singularName = null;
    private JButton bWeniger;
    private JButton bMehr;
    private JTextField tModelle;
    private JLabel lName;
    private int gesamtBreiteButtons;
    private Font unControlledFont = new Font("arial", Font.ITALIC, 12);
    private Font controlledFont = new Font("arial", Font.PLAIN, 12);


    public AnzahlPanel(int ID, int lX, int lY, String name, int minModelle, int maxModelle, double preis) {
        init(ID, lX, lY, name, minModelle, maxModelle, preis);
    }

    public AnzahlPanel(int ID, int lX, int lY, String singular, String name, int minModelle, int maxModelle, double preis) {
        this.singularName = singular;
        init(ID, lX, lY, name, minModelle, maxModelle, preis);
    }

    public AnzahlPanel(int ID, int lX, int lY, String kurzerName, int minModelle, int maxModelle, String name, String langerName, int start) {
        this.modelle = start;
        this.kurzerName = kurzerName;
        this.langerName = langerName;
        init(ID, lX, lY, name, minModelle, maxModelle, -88);
    }

    public AnzahlPanel(int ID, int lX, int lY, String kurzerName, int minModelle, int maxModelle, double preis, String name) {
        this.kurzerName = kurzerName;
        init(ID, lX, lY, name, minModelle, maxModelle, preis);
    }

    public void setNichtDieErsteOption(boolean b) {
        this.nichtDieErsteOption = b;
    }

    public void setZeilenumbruchZuvor(boolean b) {
        this.zeilenumbruchZuvor = b;
    }

    public void setGrundkosten(double i) {
        this.grundkosten = i;
    }

    public void setMaxModelle(int i) {
        this.maxModelle = i;
        if (this.getModelle() > maxModelle) {
            setModelle(maxModelle);
        }
    }

    @Override
    public boolean isLegal() {
        return this.legal;
    }

    @Override
    public void setLegal(boolean b) {
        if (legal != b) {
            if (b) {
                bWeniger.setForeground(Color.BLACK);
                bMehr.setForeground(Color.BLACK);
                tModelle.setForeground(Color.BLACK);
            } else {
                bWeniger.setForeground(Color.RED);
                bMehr.setForeground(Color.RED);
                tModelle.setForeground(Color.RED);
            }
        }

        legal = b;
    }

    @Override
    public boolean isSelected() {
        return modelle > 0 || preis == -88;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        lNameTextGenerieren();
    }

    @Override
    public double getKosten() {
        if (preis == -88) return 0;
        return grundkosten + (this.preis * this.modelle);
    }

    public int getModelle() {
        return modelle;
    }

    @Override
    public void setModelle(int anzahl) {
        this.modelle = anzahl;
        tModelle.setText(modelle + "");
    }

    public void init(int ID, int lX, int lY, String name, int minModelle, int maxModelle, double preis) {
        this.name = name;
        this.minModelle = minModelle;
        this.maxModelle = maxModelle;
        if (modelle == -1) this.modelle = minModelle;
        this.preis = preis;

        produceButtons();

        this.panel.setLocation(lX, lY);
        tModelle.addKeyListener(this);

        new RefreshListener((byte) 1, ID) {
            @Override
            public void refresh() {
                control();
            }
        };
    }

    public void produceButtons() {
        panel.setSize(auswahlBreite - (randAbstand * 2) - (int) (panel.getLocation().getX()), buttonHoehe);  // *2 weils ja vorne und hinten den BuildaHQ.abstand hat

        bWeniger = new JButton("<");
        bMehr = new JButton(">");

        BuildaHQ.newGUIComponent(bWeniger);
        BuildaHQ.newGUIComponent(bMehr);

        tModelle = new JTextField(modelle + "");

        BuildaHQ.newGUIComponent(tModelle);

        lName = new JLabel("");
        lName.setFont(new Font("arial", Font.PLAIN, 12));
        lName.setBackground(Color.WHITE);
        lNameTextGenerieren();

        bWeniger.setBounds(0, 2, 41, 16);
        tModelle.setBounds(43, 1, 31, 18);
        bMehr.setBounds(75, 2, 41, 16);
        bMehr.setMargin(new Insets(0, 0, 0, 0));
        bWeniger.setMargin(new Insets(0, 0, 0, 0));

        gesamtBreiteButtons = 92;

        lName.setBounds(125, 2, auswahlBreite - gesamtBreiteButtons, 16);
        panel.add(bWeniger);
        panel.add(bMehr);
        panel.add(tModelle);
        panel.add(lName);

        bWeniger.addMouseListener(this);
        bMehr.addMouseListener(this);
    }

    public void lNameTextGenerieren() {
        String n;

        if (kurzerName != null) {
            n = kurzerName;
        } else {
            n = name;
        }

        if (singularName != null && getModelle() == 1) {
            n = singularName;
        }

        FontMetrics fm = lName.getFontMetrics(lName.getFont());
        StringBuilder abstandshalter = new StringBuilder("");
        int cnt = (panel.getSize().width - 130 - (fm.stringWidth(n + BuildaHQ.translate("jeweils") + " " + entferneNullNachkomma(preis) + " " + BuildaHQ.translate("Pkt.")))) / fm.stringWidth(" .");

        for (int i = 0; i < cnt; ++i) {
            abstandshalter.append(" .");
        }

        lName.setText(n + abstandshalter.toString() + BuildaHQ.translate("jeweils") + " " + entferneNullNachkomma(preis) + " " + BuildaHQ.translate("Pkt."));
    }

    public void mouseReleased(MouseEvent event) {
        if (((JButton) event.getSource()).getText().equals("<")) {
            if (event.getButton() == MouseEvent.BUTTON2) {
                if (abschaltbar) {
                    modelle = 0;
                } else {
                    modelle = minModelle;
                }
            } else {
                if (abschaltbar && modelle - 1 < minModelle) {
                    modelle = 0;
                } else if (modelle - 1 >= minModelle) {
                    --modelle;
                }
            }
        } else if (((JButton) event.getSource()).getText().equals(">")) {
            if (modelle == 0 && abschaltbar) {
                modelle = minModelle;
            } else if (event.getButton() == MouseEvent.BUTTON2) {
                modelle = maxModelle;
            } else if (modelle + 1 <= maxModelle) {
                ++modelle;
            }
        }

        tModelle.setText(modelle + "");
        controlled = false;
        RefreshListener.fireRefresh();

        if (singularName != null) {
            lNameTextGenerieren();
        }
    }

    public void control() {
        if (!controlled) {
            if (modelle > maxModelle) {
                modelle = maxModelle;
            }
            if (modelle < minModelle) {
                if (abschaltbar) {
                    modelle = 0;
                } else {
                    modelle = minModelle;
                }
            }
            setModelle(modelle);
            controlled = true;
            tModelle.setFont(controlledFont);
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        int anzahl = minModelle;

        try {
            anzahl = Integer.parseInt(tModelle.getText());
        } catch (Exception blubb) {
        }

        setModelle(anzahl);
        tModelle.setFont(unControlledFont);
        controlled = false;
    }

    public void setAbschaltbar(boolean b) {
        abschaltbar = b;
    }

    @Override
    public String getText() {
        if (getModelle() <= 0) {
            return "";
        }

        String kosten = "";

        if (BuildaHQ.allePunktkosten) {
            kosten = punkteAbstandHalter + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Pkt.");
        }

        String n = name;

        if (singularName != null && getModelle() == 1) {
            n = singularName;
        }
        if (langerName != null && !BuildaHQ.kurzerText) {
            n = langerName;
        }

        if (preis == -88) {
            return BuildaHQ.formatierFett((nichtDieErsteOption ? BuildaHQ.abstand : "") + n + ": " + getModelle());
        }

        if (nichtDieErsteOption) {
            return BuildaHQ.abstand + BuildaHQ.formatierFett(getModelle() + " " + n) + kosten;
        } else {
            return BuildaHQ.formatierFett((this.zeilenumbruchZuvor ? "\n" : "") + getModelle() + " " + n) + kosten;
        }
    }

    @Override
    public String getSaveText() {
        control();
        return String.valueOf(this.getModelle());
    }

    @Override
    public Element getSaveElement() {
        control();

        Element root = BuildaHQ.getNewXMLElement(ELEMENT_NAME_COUNTER);
        root.setAttribute("number", Integer.toString(getModelle()));

        return root;
    }

    @Override
    public void load(String s) {
        try {
            modelle = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            modelle = -88;
        }

        tModelle.setText(String.valueOf(modelle));
    }

    @Override
    public void loadElement(Element e) {
        try {
            modelle = Integer.parseInt(e.getAttribute("number"));
        } catch (NumberFormatException ex) {
            modelle = -88;
        }
    }

    @Override
    public String getLabel() {
        return "";
    }
}
