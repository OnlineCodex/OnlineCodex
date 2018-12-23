package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHBloodmaster extends Eintrag {

    public CHBloodmaster() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, INFANTRY, BLOODLETTER, HERALD_OF_KHORNE, BLOODMASTER);
        name = "Bloodmaster";
        grundkosten = getPts("Bloodmaster");
        power = 3;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
