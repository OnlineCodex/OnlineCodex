package oc;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class OptionsPanelSwitcher extends OptionsVater {

    private static final int NO_PANEL = -1;
    private final SwitcherJPanel[] panels;
    private int currentPanel = 0;

    public OptionsPanelSwitcher(int lX, int lY, OptionsVater[]... options) { // das options-Array wird genau in ein Panel-Array umgesetzt, BEIM PANEL ARRAY WIRD ABER EIN leeres Panel an Stelle [0] hinzugefügt ! (für NO_PANEL ...)
        panel.setLocation(lX, lY);
        panels = new SwitcherJPanel[options.length + 1];

        panels[0] = new SwitcherJPanel(null, true); // leeres Panel zum abschalten von OptionsPanelSwitcher
        panels[0].optionen = new OptionsVater[0];

        for (int i = 1; i < panels.length; ++i) {
            panels[i] = new SwitcherJPanel(null, true);
            panels[i].optionen = options[i - 1];
            int cnt = 0;

            for (int e = 0; e < options[i - 1].length; ++e) {
                options[i - 1][e].getPanel().setLocation(0, cnt);
                panels[i].add(options[i - 1][e].getPanel());
                cnt += options[i - 1][e].getHoehe();
            }

            panels[i].setBounds(0, 0, MAXIMAL_OPTIONS_WIDTH, cnt);
        }
    }

    public void switchPanel(int index) { // diesselben indexe, wie man die Parameter angegeben hat. Erstes ParamterArray [0] usw...
        if (index + 1 != currentPanel) {
            panel.removeAll();
            if (index < 0 || index >= panels.length || index == NO_PANEL) {
                currentPanel = 0;
                panel.setSize(0, 0);
            }

            currentPanel = index + 1;
            panel.add(panels[currentPanel]);
            panel.setSize(panels[currentPanel].getSize());
        }
    }

    public void forceSwitchPanel(int index) { // diesselben indexe, wie man die Parameter angegeben hat. Erstes ParamterArray [0] usw...
        if (index + 1 != currentPanel) {
            panel.removeAll();
            currentPanel = 0;
            panel.setSize(0, 0);

            currentPanel = index + 1;
            panel.add(panels[currentPanel]);
            panel.setSize(panels[currentPanel].getSize());
        }
    }

    @Override
    public double getKosten() {
        double kosten = 0;

        for (int i = 0; i < panels[currentPanel].optionen.length; ++i) {
            kosten += panels[currentPanel].optionen[i].getKosten();
        }

        return kosten;
    }

    @Override
    public String getText() {
        final StringBuilder text = new StringBuilder();

        for (int i = 0; i < panels[currentPanel].optionen.length; ++i) {
            if (panels[currentPanel].optionen[i].isSelected()) {
                text.append(panels[currentPanel].optionen[i].getText());
            }
        }

        return text.toString();
    }

    @Override
    public String getSaveText() {
        final StringBuilder s = new StringBuilder((currentPanel - 1) + SAVETEXT_CURRNETPANELTRENNER); // currentPanel-1 is wichtig! der Parameter bei switchPanel(), den man übergibt, wird nämlich +1 genommen, bevor er benutzt wird

        for (int i = 0; i < panels[currentPanel].optionen.length; ++i) {
            s.append(panels[currentPanel].optionen[i].getSaveText() + SAVETEXT_PANELSWITCHERTRENNER);
        }

        return s.toString();
    }

    @Override
	public Element getSaveElement() {
        final Element root = BuildaHQ.getNewXMLElement(this.getClass().getSimpleName());
        root.setAttribute("currentPanel", Integer.toString(currentPanel - 1));

        for (int i = 0; i < panels[currentPanel].optionen.length; i++) {
            root.appendChild(panels[currentPanel].optionen[i].getSaveElement());
        }

        return root;
    }

    @Override
    public void load(String s) {
        switchPanel(Integer.parseInt(s.substring(0, s.indexOf(SAVETEXT_CURRNETPANELTRENNER))));
        s = s.substring(s.indexOf(SAVETEXT_CURRNETPANELTRENNER) + SAVETEXT_CURRNETPANELTRENNER.length(), s.length());
        final String[] splittet = s.split(SAVETEXT_PANELSWITCHERTRENNER);

        for (int i = 0; i < panels[currentPanel].optionen.length; ++i) {
            panels[currentPanel].optionen[i].load(splittet[i]);
        }
    }

    @Override
	public void loadElement(Element e) {
        switchPanel(Integer.parseInt(e.getAttribute("currentPanel")));

        final NodeList children = e.getChildNodes();

        for (int i = 0; i < panels[currentPanel].optionen.length; i++) {
            panels[currentPanel].optionen[i].loadElement((Element) children.item(i));
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    @Override
    public boolean isLegal() {
        return true;
    }

    @Override
    public void setLegal(boolean b) {
        if (panels != null) {
            for (int j = 0; j < panels.length; j++) {
                for (int i = 0; i < panels[j].optionen.length; i++) {
                    panels[j].optionen[i].setLegal(b);
                }
            }
        }
    }

    @Override
    public boolean isSelected() {
        return true;
    }

    @Override
    public String getLabel() {
        return "";
    }

    static class SwitcherJPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        OptionsVater[] optionen;

        public SwitcherJPanel(LayoutManager o, boolean b) {
            super(o, b);
            this.setBackground(Color.WHITE);
        }
    }
}
