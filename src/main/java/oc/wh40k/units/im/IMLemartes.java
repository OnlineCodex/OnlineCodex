package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMLemartes extends Eintrag {

    public IMLemartes() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, DEATH_COMPANY, CHARACTER, INFANTRY, CHAPLAIN, JUMP_PACK, FLY, LEMARTES);
        name = "Lemartes";
        grundkosten = getPts("Lemartes");
        power = 7;
        
        seperator();
        
        addWarlordTraits("Soulwarden (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        this.setUnikat(true);
    }
}
