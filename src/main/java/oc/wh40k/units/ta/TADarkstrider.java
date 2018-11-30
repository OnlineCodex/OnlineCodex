package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TADarkstrider extends Eintrag {
	

    public TADarkstrider() {
        name = "Darkstrider";
        grundkosten = getPts("Darkstrider");
        power = 3;
        
        seperator();

        addWarlordTraits("", true);

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
