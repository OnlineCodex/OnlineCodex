package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.CHAPLAIN;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATHWATCH;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PRIMARIS;

import oc.Eintrag;

public class IMDeathwatchPrimarisChaplain extends Eintrag {

    public IMDeathwatchPrimarisChaplain() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, DEATHWATCH, CHARACTER, INFANTRY, CHAPLAIN, PRIMARIS);

        name = "Primaris Chaplain";
        grundkosten = getPts("Primaris Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        addWeapons(IMDeathwatchRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
    }
}
