package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHBloodthirsterofUnfetteredFury extends Eintrag {

    public CHBloodthirsterofUnfetteredFury() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY);

        name = "Bloodthirster of Unfettered Fury";
        grundkosten = getPts("Bloodthirster of Unfettered Fury");
        power = 17;
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), true);
        
        seperator();
        
        addWarlordTraits("", KHORNE);
        
        complete();
    }
}
