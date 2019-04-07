package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.KEEPER_OF_SECRETS;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHKeeperofSecrets extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHKeeperofSecrets() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, MONSTER, PSYKER, KEEPER_OF_SECRETS);

        name = "Keeper of Secrets";
        grundkosten = getPts("Keeper of Secrets");
        power = 12;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSlaanesh();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", SLAANESH);

        complete();

    }
}
