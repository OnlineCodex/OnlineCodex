package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofTzeentch extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHDaemonPrinceofTzeentch() {
    	super(CHAOS, HERETIC_ASTARTES, THOUSAND_SONS, DAEMON, TZEENTCH, CHARACTER, MONSTER, DAEMON_PRINCE, PSYKER);

        name = "Daemon Prince of Tzeentch";
        grundkosten = getPts("Daemon Prince of Tzeentch") + getPts("Malefic talons");
        power = 10;

        seperator();

        addWeapons(CHThousandSonsRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).setTzeentch(true);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", true);

        complete();

    }
}
