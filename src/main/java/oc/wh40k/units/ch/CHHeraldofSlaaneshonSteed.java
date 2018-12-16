package oc.wh40k.units.ch;

import static oc.KeyWord.*;

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
