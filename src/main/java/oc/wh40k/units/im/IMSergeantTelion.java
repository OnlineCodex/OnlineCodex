package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMSergeantTelion extends Eintrag {

    public IMSergeantTelion() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, SCOUT, TELION);
    	
        name = "Sergeant Telion";
        grundkosten = getPts("Sergeant Telion");
        power = 5;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
