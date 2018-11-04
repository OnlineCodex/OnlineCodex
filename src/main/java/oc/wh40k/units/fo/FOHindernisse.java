package oc.wh40k.units.fo;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class FOHindernisse extends RuestkammerVater {

    OptionsZaehlerGruppe ozg1;

    public FOHindernisse() {
    }

    public void initButtons(boolean... defaults) {
        name = "Hindernisse";
        grundkosten = 0;

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