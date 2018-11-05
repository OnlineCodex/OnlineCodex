package oc.wh40k.units.fo;

import oc.*;

public class FOAquillaArtilleriebunker extends Eintrag {

    OptionsUpgradeGruppe oug1;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe ozg1;
    OptionsUpgradeGruppe o2;
    OptionsZaehlerGruppe ozg2;

    public FOAquillaArtilleriebunker() {
        name = "Aquilla-Artilleriebunker";
        grundkosten = 425;//Eigentlich 535, mit dem neuen Plasma-Obliberator ist das Teil aber billiger, die Zusatzkosten sind jetz bei den anderen beiden Waffen dabei.
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma Obliterator", 0));
        ogE.addElement(new OptionsGruppeEintrag("Makrokanone", 115));
        ogE.addElement(new OptionsGruppeEintrag("Warpfeldraketen", 115));
        add(oug1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Schwere Bolter", 4, 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Deflektorschild", 25));
        ogE.addElement(new OptionsGruppeEintrag("Fluchtluke", 25));
        ogE.addElement(new OptionsGruppeEintrag("Magos-Maschinengeist", 30));
        ogE.addElement(new OptionsGruppeEintrag("Munitionsdepot", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sprengfallen", 20));
        ogE.addElement(new OptionsGruppeEintrag("Suchscheinwerfer", 5));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
        //o1.setHeadline("Hauptbunker");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
        ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
        ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
        add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Deflektorschild", 25));
        ogE.addElement(new OptionsGruppeEintrag("Fluchtluke", 25));
        ogE.addElement(new OptionsGruppeEintrag("Magos-Maschinengeist", 30));
        ogE.addElement(new OptionsGruppeEintrag("Munitionsdepot", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sprengfallen", 20));
        ogE.addElement(new OptionsGruppeEintrag("Suchscheinwerfer", 5));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
        //o2.setHeadline("Bunkersektion");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
        ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
        ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
        add(ozg2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));


        complete();
    }

    @Override
    public void refreshen() {
        if (!oug1.isSelected()) {
            oug1.setSelected(0, true);
        }
    }
}