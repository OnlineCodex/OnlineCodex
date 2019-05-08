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

public class CHSyllEsske extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHSyllEsske() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, MONSTER, PSYKER, KEEPER_OF_SECRETS);

        name = "Syll'Esske";
        grundkosten = getPts("Syll Esske");
        power = 11;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSlaanesh();
        ((PsychicPowers) psychicPowers.getKammer()).setSlaanesh(true);
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("Slaanesh: Bewitching Aura", SLAANESH);

        complete();

    }
}
