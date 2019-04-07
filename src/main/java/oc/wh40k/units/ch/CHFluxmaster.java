package oc.wh40k.units.ch;

import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.FLUXMASTER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.HERALD_OF_TZEENTCH;
import static oc.KeyWord.HORROR;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFluxmaster extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public CHFluxmaster() {
        super(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FLUXMASTER);

        name = "Fluxmaster";
        grundkosten = getPts("Fluxmaster");
        power = 5;

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", TZEENTCH);

        complete();
    }
}
