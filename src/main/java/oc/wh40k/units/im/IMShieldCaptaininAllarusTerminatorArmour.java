package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_CUSTODES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SHIELD_CAPTAIN;
import static oc.KeyWord.TERMINATOR;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

public class IMShieldCaptaininAllarusTerminatorArmour extends Eintrag {
	
    public IMShieldCaptaininAllarusTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_CUSTODES, CHARACTER, INFANTRY, SHIELD_CAPTAIN, TERMINATOR);
    	
        name = "Shield Captain in Allarus Terminator Armour";
        grundkosten = getPts("Shield-Captain in Allarus Terminator Armour");
        power = 8;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));
        
        seperator();
        
        addWeapons(IMAdeptusCustodesRuestkammer.class, true);

        seperator();
        
		addWarlordTraits("", true);

        complete();

    }
}

