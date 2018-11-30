package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMUlriktheSlayer extends Eintrag {
	

    public IMUlriktheSlayer() {
        name = "Ulrik the Slayer";
        grundkosten = getPts("Ulrik the Slayer");
        power = 7;

        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
