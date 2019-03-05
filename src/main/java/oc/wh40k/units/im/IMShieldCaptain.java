package oc.wh40k.units.im;

import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.ADEPTUS_CUSTODES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.SHIELD_CAPTAIN;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

public class IMShieldCaptain extends Eintrag {
	

    public IMShieldCaptain() {
    	super(IMPERIUM, ADEPTUS_CUSTODES, CHARACTER, INFANTRY, SHIELD_CAPTAIN);
    	    	
        name = "Shield Captain";
        grundkosten = getPts("Shield Captain");
        power = 7;

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));
                
        seperator();
        
        addWeapons(IMAdeptusCustodesRuestkammer.class, true);

        seperator();

		addWarlordTraits("", true);

        complete();
    } 

}

