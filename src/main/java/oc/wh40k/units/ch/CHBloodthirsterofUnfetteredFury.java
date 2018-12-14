package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHBloodthirsterofUnfetteredFury extends Eintrag {


    public CHBloodthirsterofUnfetteredFury() {

        name = "Bloodthirster of Unfettered Fury";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;
        
        seperator();
        
        addWarlordTraits("", true, KHORNE);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
