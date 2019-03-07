package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;

public class AESolitaire extends Eintrag {
	
    public AESolitaire() {
    	super(AELDARI, CHARACTER, HARLEQUINS, INFANTRY, SOLITAIRE);
    	
        name = "Solitaire";
        grundkosten = getPts("Solitaire") ;
        power = 6;
        
        seperator();
        
        addWeapons(AEHarlequinsRuestkammer.class, true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}