package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMBelisariusCawl extends Eintrag {
	

    public IMBelisariusCawl() {
        name = "Belisarius Cawl";
        grundkosten = getPts("Belisarius Cawl");
        power = 13;
        
        seperator();

        addWarlordTraits("Mars: Static Psalm-code (AdMech)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
