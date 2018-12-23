package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_SLAANESH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHKeeperofSecrets extends Eintrag {

    public CHKeeperofSecrets() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, MONSTER, PSYKER, KEEPER_OF_SECRETS);
        name = "Keeper of Secrets";
        grundkosten = getPts("Keeper of Secrets");
        power = 11;

        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DISCIPLINE_OF_SLAANESH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", SLAANESH);

        complete();
    }
}
