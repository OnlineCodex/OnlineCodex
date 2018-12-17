package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMTheSanguinor extends Eintrag {

    public IMTheSanguinor() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, JUMP_PACK, FLY, THE_SANGUINOR);
        name = "The Sanguinor";
        grundkosten = getPts("The Sanguinor");
        power = 9;
        
        seperator();
        
        addWarlordTraits("Heroic Bearing (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
