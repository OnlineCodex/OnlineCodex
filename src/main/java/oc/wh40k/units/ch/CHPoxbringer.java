package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_NURGLE;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PLAGUEBEARER;
import static oc.KeyWord.POXBRINGER;
import static oc.KeyWord.PSYKER;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHPoxbringer extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHPoxbringer() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, PSYKER, HERALD_OF_NURGLE, POXBRINGER);
        name = "Poxbringer";
        grundkosten = getPts("Poxbringer") /*+ getPts("Balesword")*/;
        power = 4;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", NURGLE);

        complete();
    }
}
