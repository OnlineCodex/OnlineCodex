package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class HHCADreadnoughtKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2, o5;
    OptionsZaehlerGruppe o3, o4, o6;

    public HHCADreadnoughtKammer() {
        grundkosten = 125;
    }

    public void initButtons(boolean... defaults) {


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin-linked heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked autocannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked missile launcher", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked lascannon", 25));
        ogE.addElement(new OptionsGruppeEintrag("Dreadnought ccw", "Dreadnought close combat weapon", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dreadnought ccw", "Dreadnought close combat weapon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist", 10));
        ogE.addElement(new OptionsGruppeEintrag("Siege Wrecker", 10));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Twin-linked missile launcher", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin-linked bolter", 0));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", 20));
        ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Extra Armour", 10));
        ogE.addElement(new OptionsGruppeEintrag("Armoured ceramite", 20));
        ogE.addElement(new OptionsGruppeEintrag("Frag assault launchers", 15));
        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", 15));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
        ogE.addElement(new OptionsGruppeEintrag("Hunter-killer missiles", 10));
        add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        o6.setAktiv(!o5.isSelected(3));

        int Zaehler1;
        int Zaehler2;

        if (o1.isSelected("Dreadnought close combat weapon")) {
            Zaehler1 = 1;
        } else {
            Zaehler1 = 0;
        }

        if (o2.isSelected("Dreadnought close combat weapon") || (o2.isSelected("Chainfist")) || (o2.isSelected("Siege Wrecker"))) {
            Zaehler2 = 1;
        } else {
            Zaehler2 = 0;
        }

        o3.setMaxAnzahl(Zaehler1 + Zaehler2 - o4.getAnzahl());
        o3.setAnzahl(0, Zaehler1 + Zaehler2 - o4.getAnzahl());
        o4.setMaxAnzahl(Zaehler1 + Zaehler2);

    }

}