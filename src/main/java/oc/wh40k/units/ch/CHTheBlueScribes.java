package oc.wh40k.units.ch;

import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.FLY;
import static oc.KeyWord.HORROR;
import static oc.KeyWord.THE_BLUE_SCRIBES;
import static oc.KeyWord.TZEENTCH;

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
