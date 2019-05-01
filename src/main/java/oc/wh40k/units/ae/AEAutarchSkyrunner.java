package oc.wh40k.units.ae;

import static oc.KeyWord.AELDARI;
import static oc.KeyWord.ASURYANI;
import static oc.KeyWord.AUTARCH;
import static oc.KeyWord.AUTARCH_SKYRUNNER;
import static oc.KeyWord.BIKER;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.INFANTRY;

import oc.BuildaHQ;
import oc.Eintrag;

public class AEAutarchSkyrunner extends Eintrag {

    public AEAutarchSkyrunner() {
    	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, AUTARCH, BIKER, FLY, AUTARCH, AUTARCH_SKYRUNNER);

        name = "Autarch Skyrunner";
        grundkosten = getPts("Autarch Skyrunner") + getPts("Twin shuriken catapult");
        power = 7;

        seperator();

        if(BuildaHQ.aktBuildaVater.getFormationType().equals("Ynnari"))
        	addWeapons(AEYnnariRuestkammer.class, true);
        else
        	addWeapons(AECraftworldRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
