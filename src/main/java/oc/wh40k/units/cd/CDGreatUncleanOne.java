package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDGreatUncleanOne extends Eintrag {

    public CDGreatUncleanOne() {

        name = "Great Unclean One";
        grundkosten = getPts("Great Unclean One");
        power = 12;
        complete();

    }

    @Override
    public void refreshen() {
    }
}
