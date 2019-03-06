package oc.wh40k.units.ae;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class AEArchon extends Eintrag {
	private final OptionsEinzelUpgrade oe1;

    public AEArchon() {
    	super(AELDARI, DRUKHARI, INFANTRY, CHARACTER, ARCHON);
    	
        name = "Archon";
        grundkosten = getPts("Archon");
        power = 4;

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));

        seperator();
        
        addWeapons(AEDrukhariRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", KABAL);
        
        complete();
    }
}
