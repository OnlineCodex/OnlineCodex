package oc.wh40k.units.im;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.OFFICER;
import static oc.KeyWord.PLATOON_COMMANDER;

import oc.Eintrag;

public class IMPlatoonCommander extends Eintrag {

    public IMPlatoonCommander() {
    	super(CHARACTER, INFANTRY, OFFICER, PLATOON_COMMANDER);

        name = "Platoon Commander";
        grundkosten = getPts("Platoon Commander") + getPts("Frag grenade (AM)");
        power = 2;

        seperator();

        addWeapons(IMAstraMilitarumRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}