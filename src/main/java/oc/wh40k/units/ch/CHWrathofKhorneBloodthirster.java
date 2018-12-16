package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHWrathofKhorneBloodthirster extends Eintrag {

    public CHWrathofKhorneBloodthirster() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, MONSTER, BLOODTHIRSTER, FLY);
        name = "Wrath Of Khorne Bloodthirster";
        grundkosten = getPts("Wrath Of Khorne Bloodthirster");
        power = 17;

        seperator();
        
        addWeapons(CHWaffenkammerCD.class, true);
        
        seperator();
        
        addWarlordTraits("", KHORNE);
        
        complete();
    }
}
