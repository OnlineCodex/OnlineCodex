package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

public class AEAutarchwithSwoopingHawkWings extends Eintrag {

    public AEAutarchwithSwoopingHawkWings() {
    	super(AELDARI, ASURYANI, CHARACTER, INFANTRY, AUTARCH, JUMP_PACK, FLY, AUTARCH);
    	
        name = "Autarch with Swooping Hawk Wings";
        grundkosten = getPts("Autarch with Swooping Hawk Wings") + getPts("Plasma grenade") + getPts("Forceshield");
        power = 4;

        seperator();

        addWeapons(AECraftworldRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

}
