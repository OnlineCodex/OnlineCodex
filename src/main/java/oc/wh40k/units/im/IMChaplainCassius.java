package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMChaplainCassius extends Eintrag {

    public IMChaplainCassius() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CHAPLAIN, CASSIUS);
    	
        name = "Chaplain Cassius";
        grundkosten = getPts("Chaplain Cassius");
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
