package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;

public class CHTheBlueScribes extends Eintrag {

    public CHTheBlueScribes() {
        super(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, THE_BLUE_SCRIBES);

        name = "The Blue Scribes";
        grundkosten = getPts("The Blue Scribes");
        power = 5;

        seperator();
        
        addWarlordTraits("Tzeentch: Daemonspark", TZEENTCH);
        
        complete();
    }

    @Override
    public void refreshen() {
    	setUnikat(true);
    }
}
