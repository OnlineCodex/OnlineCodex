package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMChaplainGrimaldus extends Eintrag {

    public IMChaplainGrimaldus() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLACK_TEMPLARS, CHARACTER, INFANTRY, CHAPLAIN, GRIMALDUS);
    	
        name = "Chaplain Grimaldus";
        grundkosten = getPts("Chaplain Grimaldus");
        power = 6;
        
        seperator();

        addWarlordTraits("Black Templars: Oathkeeper", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}

