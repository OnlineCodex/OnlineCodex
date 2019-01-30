package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHInfernalEnrapturess extends Eintrag {

    RuestkammerStarter psychicPowers;

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
