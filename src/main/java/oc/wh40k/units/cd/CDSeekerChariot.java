package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDSeekerChariot extends Eintrag {

    public CDSeekerChariot() {
        name = "Seeker Chariot";
        grundkosten = getPts("Seeker Chariot");
        power = 4;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
