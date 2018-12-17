package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMAstorath extends Eintrag {

    public IMAstorath() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, CHAPLAIN, JUMP_PACK, FLY, ASTORATH);
        name = "Astorath";
        grundkosten = getPts("Astorath");
        power = 8;
        seperator();
        
        addWarlordTraits("Soulwarden (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        this.setUnikat(true);
    }
}
