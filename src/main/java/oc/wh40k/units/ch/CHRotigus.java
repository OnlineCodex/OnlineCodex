package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.GREAT_UNCLEAN_ONE;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.ROTIGUS;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHRotigus extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHRotigus() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, MONSTER, PSYKER, GREAT_UNCLEAN_ONE, ROTIGUS);

        name = "Rotigus";
        grundkosten = getPts("Rotigus");
        power = 17;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("Nurgle: Pestilent Miasma", NURGLE);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
