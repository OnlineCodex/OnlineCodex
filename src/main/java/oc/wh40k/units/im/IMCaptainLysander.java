package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCaptainLysander extends Eintrag {

    public IMCaptainLysander() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, IMPERIAL_FISTS, CHARACTER, INFANTRY, CAPTAIN, TERMINATOR, LYSANDER);
    	
        name = "Captain Lysander";
        grundkosten = getPts("Captain Lysander");
        power = 8;
        
        seperator();

        addWarlordTraits("Imperial Fists: Architect of War", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}