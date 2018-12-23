package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHBloodthirsterofInsensateRage extends Eintrag {

    public CHBloodthirsterofInsensateRage() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY);

        name = "Bloodthirster of Insensate Rage";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);
        
        seperator();
        
        addWarlordTraits("", KHORNE);
        
        complete();
    }
}
