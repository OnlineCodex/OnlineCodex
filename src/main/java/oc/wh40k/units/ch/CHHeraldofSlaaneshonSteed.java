package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;

public class CHHeraldofSlaaneshonSteed extends Eintrag {

    public CHHeraldofSlaaneshonSteed() {
        name = "Herald of Slaanesh on Steed";
        grundkosten = getPts("Herald of Slaanesh on Steed");
        power = 4;
        setKeywords(ImmutableSet.of(CHAOS, SLAANESH, DAEMON, CHARACTER, CAVALRY, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);
        
        seperator();
        
        addWarlordTraits("", true, SLAANESH);

        complete();
    }
}
