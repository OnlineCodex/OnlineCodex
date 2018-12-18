package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCaptainTycho extends Eintrag {

    public IMCaptainTycho() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, CAPTAIN, TYCHO);
        name = "Captain Tycho";
        grundkosten = getPts("Captain Tycho");
        power = 5;
        seperator();
        
        addWarlordTraits("Selfless Valour (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
