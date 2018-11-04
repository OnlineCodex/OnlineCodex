package oc.wh40k.units.ae;

import oc.Eintrag;

public class AECrimsonHunter extends Eintrag {

    public AECrimsonHunter() {
        name = "Crimson Hunter";
        grundkosten = getPts("Crimson Hunter") + 2 * getPts("Bright lance") + getPts("Pulse laser");
        power = 9;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
    }
}