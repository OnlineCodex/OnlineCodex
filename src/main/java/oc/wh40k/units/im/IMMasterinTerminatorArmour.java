package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMMasterinTerminatorArmour extends Eintrag {

    public IMMasterinTerminatorArmour() {
    	super(TODO);
        name = "Master in Terminator Armour";
        grundkosten = getPts("Master in Terminator Armour");
        power = 7;

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
