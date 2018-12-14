package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHTheMasqueofSlaanesh extends Eintrag {

    public CHTheMasqueofSlaanesh() {

        name = "The Masque of Slaanesh";
        grundkosten = getPts("The Masque of Slaanesh");
        power = 4;
        
        seperator();
        
        addWarlordTraits("Slaanesh: The Murderdance", true, SLAANESH);
        
        complete();
    }

    @Override
    public void refreshen() {
    	setUnikat(true);
    }
}
