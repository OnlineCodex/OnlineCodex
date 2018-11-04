package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDExaltedSeekerChariot extends Eintrag {

    public CDExaltedSeekerChariot() {
        name = "Exalted Seeker Chariot";
        grundkosten = getPts("Exalted Seeker Chariot");
        power = 5;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
