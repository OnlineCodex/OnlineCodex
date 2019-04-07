package oc.wh40k.units.ch;

import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMONETTE;
import static oc.KeyWord.HERALD_OF_SLAANESH;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;

import oc.Eintrag;

public class CHHeraldofSlaaneshonSteed extends Eintrag {

    public CHHeraldofSlaaneshonSteed() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, CAVALRY, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH);
        name = "Herald of Slaanesh on Steed";
        grundkosten = getPts("Herald of Slaanesh on Steed");
        power = 4;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        addWarlordTraits("", SLAANESH);

        complete();
    }
}
