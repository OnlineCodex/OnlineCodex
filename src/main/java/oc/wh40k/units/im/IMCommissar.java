package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMCommissar extends Eintrag {

    public IMCommissar() {
    	super(IMPERIUM, ASTRA_MILITARUM, INFANTRY, CHARACTER, COMMISSAR);
    	
        name = "Commissar";
        grundkosten = getPts("Commissar");
        power = 2;

        seperator();
        
        addWeapons(IMAstraMilitarumRuestkammer.class, true);
                
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}