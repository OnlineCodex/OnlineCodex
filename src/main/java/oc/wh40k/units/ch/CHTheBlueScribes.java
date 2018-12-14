package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHTheBlueScribes extends Eintrag {

    public CHTheBlueScribes() {

        name = "The Blue Scribes";
        grundkosten = getPts("The Blue Scribes");
        power = 5;
        
        seperator();
        
        addWarlordTraits("Tzeentch: Daemonspark", true, TZEENTCH);
        
        complete();
    }

    @Override
    public void refreshen() {
    	setUnikat(true);
    }
}
