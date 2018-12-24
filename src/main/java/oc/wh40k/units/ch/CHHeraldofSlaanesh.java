package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_SLAANESH;

public class CHHeraldofSlaanesh extends Eintrag {

    public CHHeraldofSlaanesh() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, INFANTRY, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH);
        name = "Herald of Slaanesh";
        grundkosten = getPts("Herald of Slaanesh");
        power = 3;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        addPsychicPowers(1, DISCIPLINE_OF_SLAANESH);

        seperator();
        
        addWarlordTraits("", SLAANESH);

        complete();
    }
}
