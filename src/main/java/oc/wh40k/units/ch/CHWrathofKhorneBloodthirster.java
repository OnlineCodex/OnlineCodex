package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHWrathofKhorneBloodthirster extends Eintrag {


    public CHWrathofKhorneBloodthirster() {
        name = "Wrath Of Khorne Bloodthirster";
        grundkosten = getPts("Wrath Of Khorne Bloodthirster");
        power = 17;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);
        
        complete();
    }
}
