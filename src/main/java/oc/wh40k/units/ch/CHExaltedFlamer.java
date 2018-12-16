package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHExaltedFlamer extends Eintrag {

    public CHExaltedFlamer() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, FLAMER, FLY, EXALTED_FLAMER);

        name = "Exalted Flamer";
        grundkosten = getPts("Exalted Flamer");
        power = 4;

        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();

    }
}
