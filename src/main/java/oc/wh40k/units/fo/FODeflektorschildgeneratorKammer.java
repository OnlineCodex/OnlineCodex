package oc.wh40k.units.fo;

import oc.*;

public class FODeflektorschildgeneratorKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe ozg1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelZaehler oez;

    public FODeflektorschildgeneratorKammer() {
    }

    public void initButtons(boolean... defaults) {
        name = "Deflektorschildgenerator";
        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

        seperator();

        add(oez = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Zus. proj. Deflektorschilde", "Zusätzliche projizierte Deflektorschilde", 2, 25));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
        ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
        ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
        add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }
}