package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHFabiusBile extends Eintrag {

    public CHFabiusBile() {

        name = "Fabius Bile";
        grundkosten = getPts("Fabius Bile");
        power = 6;
        complete();

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
