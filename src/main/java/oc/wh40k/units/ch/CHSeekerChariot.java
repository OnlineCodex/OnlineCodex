package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSeekerChariot extends Eintrag {

    public CHSeekerChariot() {
        name = "Seeker Chariot";
        grundkosten = getPts("Seeker Chariot");
        power = 4;

        complete();
    }

    @Override
    public void refreshen() {

    }

}
