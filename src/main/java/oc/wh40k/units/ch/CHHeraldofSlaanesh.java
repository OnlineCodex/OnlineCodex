package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_SLAANESH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHHeraldofSlaanesh extends Eintrag {

    public CHHeraldofSlaanesh() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, INFANTRY, PSYKER, DAEMONETTE, HERALD_OF_SLAANESH);
        name = "Herald of Slaanesh";
        grundkosten = getPts("Herald of Slaanesh");
        power = 3;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, DISCIPLINE_OF_SLAANESH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", SLAANESH);

        complete();
    }
}
