package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DEATH_GUARD;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMON_PRINCE;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.MONSTER;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofNurgle extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHDaemonPrinceofNurgle() {

    	super(CHAOS, NURGLE, HERETIC_ASTARTES, DEATH_GUARD, CHARACTER, DAEMON, MONSTER, DAEMON_PRINCE);
    	
        name = "Daemon Prince of Nurgle";
        grundkosten = getPts("Daemon Prince of Nurgle") + getPts("Malefic talons");
        power = 10;

        seperator();
        
        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
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
