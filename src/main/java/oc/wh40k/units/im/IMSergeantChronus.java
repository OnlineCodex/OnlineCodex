package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMSergeantChronus extends Eintrag {

    public IMSergeantChronus() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, CHRONUS);
    	
        name = "Sergeant Chronus";
        grundkosten = getPts("Sergeant Chronus");
        power = 3;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
