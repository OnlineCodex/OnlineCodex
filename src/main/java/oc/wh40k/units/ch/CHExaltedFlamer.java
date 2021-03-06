package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.EXALTED_FLAMER;
import static oc.KeyWord.FLAMER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;

public class CHExaltedFlamer extends Eintrag {

    public CHExaltedFlamer() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, FLAMER, FLY, EXALTED_FLAMER);

        name = "Exalted Flamer";
        grundkosten = getPts("Exalted Flamer");
        power = 5;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        addWarlordTraits("", TZEENTCH);

        complete();

    }
}
