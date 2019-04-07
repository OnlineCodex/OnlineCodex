package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.WATCH_CAPTAIN;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IMWatchCaptain extends Eintrag {

    public IMWatchCaptain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, WATCH_CAPTAIN);

        name = "Watch Captain";
        grundkosten = getPts("Watch Captain");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Watch Captain with Jump Pack") - getPts("Watch Captain")));

        seperator();

        addWeapons(IMDeathwatchRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

}
