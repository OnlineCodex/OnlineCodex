package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHWrathofKhorneBloodthirster extends Eintrag {


    public CHWrathofKhorneBloodthirster() {
        name = "Wrath Of Khorne Bloodthirster";
        grundkosten = getPts("Wrath Of Khorne Bloodthirster");
        power = 17;
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);
        
        complete();
    }
}
