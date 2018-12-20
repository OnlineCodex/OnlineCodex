package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCelestine extends Eintrag {

    public IMCelestine() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, CHARACTER, INFANTRY, JUMP_PACK, FLY, CELESTINE);
        name = "Celestine";
        grundkosten = getPts("Celestine");
        power = 8;
        
        seperator();

        addWarlordTraits("Beacon of Faith", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
