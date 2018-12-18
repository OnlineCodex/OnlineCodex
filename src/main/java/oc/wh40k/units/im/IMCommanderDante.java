package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCommanderDante extends Eintrag {

    public IMCommanderDante() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, CHAPTER_MASTER, JUMP_PACK, FLY, COMMANDER_DANTE);
        name = "Commander Dante";
        grundkosten = getPts("Commander Dante");
        power = 11;
        
        seperator();
        
        addWarlordTraits("Heroic Bearing (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
