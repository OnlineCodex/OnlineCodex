package oc.wh40k.units.ch;

import static oc.KeyWord.BE_LAKOR;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMON_PRINCE;
import static oc.KeyWord.FLY;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.PSYKER;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHBeLakor extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHBeLakor() {
        super(CHAOS, DAEMON, CHARACTER, MONSTER, DAEMON_PRINCE, FLY, PSYKER, BE_LAKOR);

        name = "Be'Lakor";
        grundkosten = getPts("Be'Lakor");
        power = 14;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
