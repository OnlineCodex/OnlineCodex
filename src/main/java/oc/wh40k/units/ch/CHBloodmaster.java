package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHBloodmaster extends Eintrag {

    public CHBloodmaster() {
        name = "Bloodmaster";
        grundkosten = getPts("Bloodmaster");
        power = 3;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
