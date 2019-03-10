package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMTempestorPrime extends Eintrag {

    public IMTempestorPrime() {
    	super(MILITARUM_TEMPESTUS, CHARACTER, INFANTRY, OFFICER, TEMPESTOR_PRIME);
    	
        name = "Tempestor Prime";
        grundkosten = getPts("Tempestor Prime") + getPts("Frag grenade (AM)") + getPts("Krak grenade (AM)");
        power = 2;

        seperator();
        
        addWeapons(IMAstraMilitarumRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}