package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMKayvaanShrike extends Eintrag {

    public IMKayvaanShrike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, RAVEN_GUARD, CHARACTER, INFANTRY, CHAPTER_MASTER, JUMP_PACK, FLY, KAYVAAN_SHRIKE);
    	
        name = "Kayvaan Shrike";
        grundkosten = getPts("Kayvaan Shrike");
        power = 8;
        
        seperator();

        addWarlordTraits("Raven Guard: Silent Stalker", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}