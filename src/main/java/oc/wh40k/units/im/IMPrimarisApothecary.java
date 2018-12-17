package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMPrimarisApothecary extends Eintrag {

    public IMPrimarisApothecary() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, APOTHECARY);
        name = "Primaris Apothecary";
        grundkosten = getPts("Primaris Apothecary") + 
        			  getPts("Frag grenade (SM)") + 
        			  getPts("Krak grenade (SM)") + 
        			  getPts("Absolver bolt pistol") + 
        			  getPts("Reductor pistol");
        
        seperator();

        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4;
    }
}
