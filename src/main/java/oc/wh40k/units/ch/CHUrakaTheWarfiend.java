package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHUrakaTheWarfiend extends Eintrag {

    public CHUrakaTheWarfiend() {

        name = "Uraka the Warfiend";
        grundkosten = getPts("Uraka the Warfiend");
        power = 9;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
