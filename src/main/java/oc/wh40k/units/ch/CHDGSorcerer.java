package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SORCERER;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHDGSorcerer extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHDGSorcerer() {
    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, INFANTRY, PSYKER, SORCERER);

        name = "Sorcerer";
        grundkosten = getPts("Sorcerer");
        power = 7;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableContagion();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", true);

        complete();

    }
}
