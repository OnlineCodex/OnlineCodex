package oc.wh40k.units.ch;

import static oc.KeyWord.BLOODLETTER;
import static oc.KeyWord.BLOODMASTER;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_KHORNE;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.KHORNE;

import oc.Eintrag;

public class CHBloodmaster extends Eintrag {

    public CHBloodmaster() {
        super(CHAOS, KHORNE, DAEMON, CHARACTER, INFANTRY, BLOODLETTER, HERALD_OF_KHORNE, BLOODMASTER);
        name = "Bloodmaster";
        grundkosten = getPts("Bloodmaster");
        power = 3;

        seperator();

        addWeapons(CHWaffenkammerCD.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }
}
