package oc.wh40k.units.fo;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class FOHimmelsschildLandeplattformKammer extends RuestkammerVater {

    OptionsZaehlerGruppe ozg1;

    public FOHimmelsschildLandeplattformKammer() {
    }

    public void initButtons(boolean... defaults) {
        name = "Himmelsschild-Landeplattform";
        grundkosten = 75;

        add(ico = new oc.Picture("oc/wh40k/images/Landeplattform.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Startklar", 5));

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