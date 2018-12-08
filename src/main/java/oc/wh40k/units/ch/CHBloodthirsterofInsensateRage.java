package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHBloodthirsterofInsensateRage extends Eintrag {

    public CHBloodthirsterofInsensateRage() {

        name = "Bloodthirster of Insensate Rage";
        grundkosten = getPts("Bloodthirster Of Insensate Rage");
        power = 17;
        
        seperator();
        
        addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
