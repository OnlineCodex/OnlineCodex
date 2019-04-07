package oc.wh40k.units.ch;

import static oc.KeyWord.BLOODLETTER;
import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_KHORNE;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.SKULLMASTER;

import oc.Eintrag;

public class CHSkullmaster extends Eintrag {

    public CHSkullmaster() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, CAVALRY, BLOODLETTER, HERALD_OF_KHORNE, SKULLMASTER);
        name = "Skullmaster";
        grundkosten = getPts("Skullmaster");
        power = 5;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        addWarlordTraits("", KHORNE);

        complete();
    }

}
