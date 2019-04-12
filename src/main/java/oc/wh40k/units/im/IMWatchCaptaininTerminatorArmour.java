package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TERMINATOR;
import static oc.KeyWord.WATCH_CAPTAIN;

import oc.Eintrag;

public class IMWatchCaptaininTerminatorArmour extends Eintrag {

    public IMWatchCaptaininTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, WATCH_CAPTAIN, TERMINATOR);

        name = "Watch Captain in Terminator Armour";
        grundkosten = getPts("Watch Captain in Terminator Armour");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        addWeapons(IMDeathwatchRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
