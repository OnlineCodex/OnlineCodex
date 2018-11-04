package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHLordArkos extends Eintrag {

    public CHLordArkos() {

        name = "Lord Arkos";
        grundkosten = getPts("Lord Arkos");
        power = 7;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
