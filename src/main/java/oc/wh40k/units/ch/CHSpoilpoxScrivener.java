package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_NURGLE;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PLAGUEBEARER;
import static oc.KeyWord.SPOILPOX_SCRIVENER;

import oc.Eintrag;

public class CHSpoilpoxScrivener extends Eintrag {

    public CHSpoilpoxScrivener() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, HERALD_OF_NURGLE, SPOILPOX_SCRIVENER);
        name = "Spoilpox Scrivener";
        grundkosten = getPts("Spoilpox Scrivener") /*+ getPts("Plaguesword") + getPts("Distended maw") + getPts("Disgusting sneezes")*/;
        power = 4;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        addWarlordTraits("", NURGLE);

        complete();
    }

    @Override
    public void refreshen() {

    }

}
