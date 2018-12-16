package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHBloodthirsterofUnfetteredFury extends Eintrag {


    public CHBloodthirsterofUnfetteredFury() {

        name = "Bloodthirster of Unfettered Fury";
        grundkosten = getPts("Bloodthirster of Unfettered Fury");
        power = 17;
        setKeywords(ImmutableSet.of(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, true);
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
