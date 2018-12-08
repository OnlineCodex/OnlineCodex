package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEIlluminorSzeras extends Eintrag {
	

    public NEIlluminorSzeras() {
        name = "Illuminor Szeras";
        grundkosten = getPts("Illuminor Szeras") + getPts("Eldritch lance");
        power = 8;
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
