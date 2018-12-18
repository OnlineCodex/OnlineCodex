package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCaptainSicarius extends Eintrag {

    public IMCaptainSicarius() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CAPTAIN, SICARIUS);
        
    	name = "Captain Sicarius";
        grundkosten = getPts("Captain Sicarius");
        power = 7;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
