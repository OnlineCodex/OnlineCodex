package oc;

import static oc.RefreshListener.addRefreshListener;
import static oc.RefreshListener.Priority.OPTIONS_COLLECTION;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public abstract class OptionsCollection extends BuildaPanel {

    protected Vector<OptionsVater> optionen = new Vector<OptionsVater>();
    protected Vector<OptionsGruppeEintrag> ogE = new Vector<OptionsGruppeEintrag>(); // wird in den  extends Eintrag  Klassen verwendet
    protected Vector<OptionsGruppeEintrag> ogEa = new Vector<OptionsGruppeEintrag>(); // wird in den  extends Eintrag  Klassen  bei Necromunda verwendet
    protected Picture ico;
    protected double grundkosten = 0;
    protected String name = "";
    protected int cnt = randAbstand;
    protected int ID; // wichtig!
    boolean überschriftSetzen = false;
    protected BuildaVater buildaVater;


    public OptionsCollection() { // zum verschieben der Rüstkammerstarter. Wenn der Eintrag selber in refresh sowas macht, ist das gültig, weil es schließlich NACH dem hier passiert (siehe reihenfolge bei RefreshListener)
        addRefreshListener(OPTIONS_COLLECTION, this::aktualisiereKammerStarterLocation);
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void seperator() {
        cnt += 10;
    }

    public void seperator(int i) {
        cnt += i;
    }

    public void add(OptionsVater o) {
        panel.add(o.getPanel());
        if (!(o instanceof Picture)) optionen.add(o);

        if (o instanceof OptionsUpgradeGruppe || o instanceof OptionsZaehlerGruppe) {
            ogE.clear();
        }

        cnt += o.getHoehe();
    }

    public void addAt(OptionsVater o, int i) {
        panel.add(o.getPanel(), i);
        optionen.add(i, o);

        if (o instanceof OptionsUpgradeGruppe || o instanceof OptionsZaehlerGruppe) {
            ogE.clear();
        }

        cnt += o.getHoehe();
    }

    public void remove(OptionsVater o) {
        panel.remove(o.getPanel());
        optionen.remove(o);
        cnt -= o.getHoehe();
    }

    public int getHöhe() {
        int höhe = 0;

        for (int i = 0; i < optionen.size(); ++i) {
            final int nächsteHöhe = (int) (optionen.elementAt(i).getPanel().getLocation().getY() + (optionen.elementAt(i).getHoehe()));
            if (höhe < nächsteHöhe) {
                höhe = nächsteHöhe;
            }
        }

        try {
            final int bildHöhe = (int) ico.getLocation().getY() + ico.getSize().height;

            if (bildHöhe + 20 > höhe) { // bei imageIcon höhe zählt noch +20 wegen dem Label unterdrunter dazu, da das Label das Bild blockiert die Buttons aber nicht
                höhe = bildHöhe + 22;
            }
        } catch (final Exception e) {
        }

        return höhe + randAbstand;
    }

    @Override
	public double getKosten() {
        double kosten = 0;

        for (int i = 0; i < optionen.size(); ++i) {
            kosten += optionen.elementAt(i).getKosten();
        }

        return kosten + grundkosten;
    }

    public String getSaveText(String trenner) {
        final StringBuilder s = new StringBuilder();

        for (int i = 0; i < optionen.size(); ++i) {
            s.append(optionen.elementAt(i).getSaveText() + trenner);
        }

        return s.toString();

    }

    public Element getSaveElement() {
        final Element root = BuildaHQ.getNewXMLElement("Collection");

        for (int i = 0; i < optionen.size(); i++) {
            root.appendChild(optionen.elementAt(i).getSaveElement());
        }

        return root;
    }

    public void load(String s, String trenner) {
        final String[] splittet = s.split(trenner);

        for (int i = 0; i < optionen.size(); ++i) {
            optionen.elementAt(i).load(splittet[i]);

            if (optionen.elementAt(i) instanceof RuestkammerStarter) {
                final RuestkammerStarter rk = ((RuestkammerStarter) optionen.elementAt(i));
                checkRuestkammerStarter(rk);
            }
        }
    }

    public void loadElement(Element e) {
        final NodeList children = e.getChildNodes();

        for (int i = 0; i < optionen.size(); ++i) {
            //                if(children.item(i) != null && children.item(i).getNodeType() == Node.ELEMENT_NODE) {
            optionen.elementAt(i).loadElement((Element) children.item(i));
            //                }

            if (optionen.elementAt(i) instanceof RuestkammerStarter) {
                final RuestkammerStarter rk = ((RuestkammerStarter) optionen.elementAt(i));
                checkRuestkammerStarter(rk);
            }
        }
    }

    public void aktualisiereKammerStarterLocation() {
        boolean ersterStarter = true;
        for (int i = 0; i < optionen.size(); ++i) {
            if (optionen.elementAt(i) instanceof RuestkammerStarter) {
                final RuestkammerStarter rk = ((RuestkammerStarter) optionen.elementAt(i));

                if (rk.isSelected()) {
                    rk.textUebernehmen();
                }

                if (ersterStarter) {
                    ersterStarter = false;
                } else {
                    final JPanel p = rk.getPanel();
                    final JPanel pMinus1 = optionen.elementAt(i - 1).getPanel(); // index-1 geht hier immer, weil es ja nich der erste Starter sein kann

                    if (p.getLocation().getX() != pMinus1.getLocation().getX()) {
                        continue;
                    } // erfüllt zusätzlich diesselbe funktion wie ersterStater bei der nächstenReihe

                    int zusatzAbstand = rk.getSeperator();

                    if (zusatzAbstand == -88) {
                        zusatzAbstand = DEFAULT_KAMMERSTARTER_Abstand_Y;
                    }

                    p.setLocation((int) p.getLocation().getX(), (int) pMinus1.getLocation().getY() + pMinus1.getSize().height + zusatzAbstand);
                }
            }
        }

    }

    public void checkRuestkammerStarter(RuestkammerStarter rk) {
        if (!(rk.getKammer().toString().indexOf("MagicItems") == -1) || !(rk.getKammer().toString().indexOf("Banner") == -1) || !(rk.getKammer().toString().indexOf("Gabe") == -1)
                || !(rk.getKammer().toString().indexOf("GiftsOf") == -1) || !(rk.getKammer().toString().indexOf("Spites") == -1) || !(rk.getKammer().toString().indexOf("Assassin") == -1)) {
            String text = "";
            if (rk.getKammer().getText().length() > 2) {
                text = BuildaHQ.translate(rk.getKammer().getText().substring(1, rk.getKammer().getText().length()));
            }
            text = text.replaceAll("\n- ", "-");
            final StringTokenizer tokenizer = new StringTokenizer(text, ",");
            while (tokenizer.hasMoreElements()) {
                final String tok = BuildaHQ.translate(tokenizer.nextToken().trim());

                if (BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)) {
                    final JOptionPane op = new JOptionPane(tok + " darf nur einmal enthalten sein.", JOptionPane.ERROR_MESSAGE);
                    final JDialog dialog = op.createDialog("Validierungs Fehler");
                    dialog.setAlwaysOnTop(true); //<-- this line
                    dialog.setModal(true);
                    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);

                }
                if (BuildaHQ.Items != null) BuildaHQ.Items.add(tok);

            }
        }
    }

    public abstract int getBreite();

    public abstract String getText();

    public BuildaVater checkBuildaVater() {
        if (buildaVater == null) {
            buildaVater = BuildaHQ.aktBuildaVater;
        }
        return buildaVater;
    }

    protected int getPts(String key) {
        return checkBuildaVater().getPts(key);
    }

    public void addToInformationVector(String s, int count) { // um wieviel der key s erhöht/vermindert wird
        checkBuildaVater();

        if (buildaVater != null) {
            buildaVater.addToInformationVector(s, count);
        }
    }

    public int getCountFromInformationVector(String s) {
        checkBuildaVater();

        if (buildaVater != null) {
            return buildaVater.getCountFromInformationVector(s);
        } else {
            return 0;
        }
    }

}
