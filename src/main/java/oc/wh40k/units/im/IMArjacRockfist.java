package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMArjacRockfist extends Eintrag {
    
	RuestkammerStarter warlord;

    public IMArjacRockfist() {
        name = "Arjac Rockfist";
        grundkosten = getPts("Arjac Rockfist");
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
