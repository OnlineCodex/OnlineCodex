package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

public class AEDeathJester extends Eintrag {

    public AEDeathJester() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, DEATHJESTER);
    	
        name = "Death Jester";
        grundkosten = getPts("Death Jester");
        power = 3;
        
        seperator();

        addWeapons(AEHarlequinsRuestkammer.class, true);
               
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}