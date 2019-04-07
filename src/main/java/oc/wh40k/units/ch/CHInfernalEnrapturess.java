package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMONETTE;
import static oc.KeyWord.HERALD_OF_SLAANESH;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;

import oc.Eintrag;

public class CHInfernalEnrapturess extends Eintrag {

    public CHInfernalEnrapturess() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, INFANTRY, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH);
        name = "Infernal Enrapturess";
        grundkosten = getPts("Infernal Enrapturess");
        power = 4;

        seperator();

        addWarlordTraits("", SLAANESH);

        complete();
    }
}
