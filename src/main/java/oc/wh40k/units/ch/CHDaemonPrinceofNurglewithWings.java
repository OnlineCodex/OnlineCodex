package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofNurglewithWings extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHDaemonPrinceofNurglewithWings() {

        name = "Daemon Prince of Nurgle with Wings";
        grundkosten = getPts("Daemon Prince of Nurgle with Wings");
        power = 10;

        seperator();

        addWeapons(CHDeathGuardRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).setNurgle(true);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
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
