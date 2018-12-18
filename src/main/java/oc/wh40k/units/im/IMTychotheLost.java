package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMTychotheLost extends Eintrag {

    public IMTychotheLost() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, DEATH_COMPANY, CHARACTER, INFANTRY, TYCHO);
        name = "Tycho the Lost";
        grundkosten = getPts("Tycho the Lost");
        power = 4;
        seperator();
        
        addWarlordTraits("Selfless Valour (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
