package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_TZEENTCH;
import static oc.KeyWord.HORROR;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.THE_CHANGELING;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTheChangeling extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHTheChangeling() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, PSYKER, HERALD_OF_TZEENTCH, HORROR, THE_CHANGELING);

        name = "The Changeling";
        grundkosten = getPts("The Changeling");
        power = 5;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        ((PsychicPowers) psychicPowers.getKammer()).setTzeentch(true);
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("Tzeentch: Incorporeal Form", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
