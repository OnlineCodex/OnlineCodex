package oc.wh40k.units.im;

import oc.Eintrag;

public class IMInterrogatorChaplaininTerminatorArmour extends Eintrag {

    public IMInterrogatorChaplaininTerminatorArmour() {
        name = "Interrogator-Chaplain in Terminator Armour";
        grundkosten = getPts("Interrogator-Chaplain in Terminator Armour") + getPts("Crozius arcanum");
        power = 6;

        seperator();

        addWeapons(IMDarkAngelsRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}