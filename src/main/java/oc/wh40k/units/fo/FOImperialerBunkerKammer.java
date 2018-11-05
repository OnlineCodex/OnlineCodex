package oc.wh40k.units.fo;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class FOImperialerBunkerKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe ozg1;
    OptionsUpgradeGruppe o2;

    public FOImperialerBunkerKammer() {
    }

    public void initButtons(boolean... defaults) {
        name = "Imperialer Bunker";
        grundkosten = 55;

        add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Voxrelais", 20));
        ogE.addElement(new OptionsGruppeEintrag("Icarus-Laserkanone", "Waffenstellung mit Icarus-Laserkanone", 35));
        ogE.addElement(new OptionsGruppeEintrag("Vierlings-Flak", "Waffenstellung mit Vierlings-Flak", 50));
        ogE.addElement(new OptionsGruppeEintrag("Munitionslager", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

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
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }
}