package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_BATTLE;

public class AEHemlockWraithfighter extends Eintrag {

    public AEHemlockWraithfighter() {
        name = "Hemlock Wraithfighter";
        grundkosten = getPts("Hemlock Wraithfighter") + 2 * getPts("Heavy D-scythe") + getPts("Spirit stones");
        power = 10;

        addPsychicPowers(1, RUNES_OF_BATTLE);

        complete();
    }
}