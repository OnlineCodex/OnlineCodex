package oc.wh40k.units.ch;

import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMON_PRINCE;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.THOUSAND_SONS;
import static oc.KeyWord.TZEENTCH;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofTzeentch extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHDaemonPrinceofTzeentch() {
    	super(CHAOS, HERETIC_ASTARTES, THOUSAND_SONS, DAEMON, TZEENTCH, CHARACTER, MONSTER, DAEMON_PRINCE);
    	
        name = "Daemon Prince of Tzeentch";
        grundkosten = getPts("Daemon Prince of Nurgle") + getPts("Malefic talons");
        power = 10;

        seperator();
        
        addWeapons(CHThousandSonsRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        addWarlordTraits("", true);

        complete();

    }
}
