package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHExaltedSeekerChariot extends Eintrag {

    public CHExaltedSeekerChariot() {
        name = "Exalted Seeker Chariot";
        grundkosten = getPts("Exalted Seeker Chariot");
        power = 5;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
