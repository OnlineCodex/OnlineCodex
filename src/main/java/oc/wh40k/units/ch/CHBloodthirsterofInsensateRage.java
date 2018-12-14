package oc.wh40k.units.ch;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHBloodthirsterofInsensateRage extends Eintrag {

    public CHBloodthirsterofInsensateRage() {

        name = "Bloodthirster of Insensate Rage";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY));
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
