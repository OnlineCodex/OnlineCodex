package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMLordCommissar extends Eintrag {

    public IMLordCommissar() {
    	super(CHARACTER, INFANTRY, COMMISSAR, LORD_COMMISSAR);
    	
        name = "Lord Commissar";
        grundkosten = getPts("Lord Commissar");
        power = 4;
        
        seperator();
        
        addWeapons(IMAstraMilitarumRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}