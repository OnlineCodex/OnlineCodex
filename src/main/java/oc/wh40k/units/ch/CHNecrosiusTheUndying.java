package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHNecrosiusTheUndying extends Eintrag {

    public CHNecrosiusTheUndying() {

        name = "Necrosius the Undying";
        grundkosten = getPts("Necrosius the Undying");
        power = 7;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
