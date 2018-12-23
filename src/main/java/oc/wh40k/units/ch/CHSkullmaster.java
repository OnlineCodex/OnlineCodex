package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHSkullmaster extends Eintrag {

    public CHSkullmaster() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, CAVALRY, BLOODLETTER, HERALD_OF_KHORNE, SKULLMASTER);
        name = "Skullmaster";
        grundkosten = getPts("Skullmaster");
        power = 5;
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);
        
        seperator();
        
        addWarlordTraits("", KHORNE);

        complete();
    }

}
