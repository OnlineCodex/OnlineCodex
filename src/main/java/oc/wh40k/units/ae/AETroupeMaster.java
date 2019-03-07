package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

public class AETroupeMaster extends Eintrag {

    public AETroupeMaster() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, TROUPE_MASTER);
    	
        name = "Troupe Master";
        grundkosten = getPts("Troupe Master");
        power = 4;

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