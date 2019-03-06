package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

public class AEAutarchSkyrunner extends Eintrag {

    public AEAutarchSkyrunner() {
    	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, AUTARCH, BIKER, FLY, AUTARCH, AUTARCH_SKYRUNNER);
    	
        name = "Autarch Skyrunner";
        grundkosten = getPts("Autarch Skyrunner") + getPts("Twin shuriken catapult");
        power = 7;

        seperator();

        addWeapons(AECraftworldRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
