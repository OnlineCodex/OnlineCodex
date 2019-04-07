package oc.wh40k.units.ch;

import static oc.KeyWord.CHANGECASTER;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.HERALD_OF_TZEENTCH;
import static oc.KeyWord.HORROR;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHChangecaster extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHChangecaster() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, HORROR, PSYKER, HERALD_OF_TZEENTCH, CHANGECASTER);
        name = "Changecaster";
        grundkosten = getPts("Changecaster");
        power = 4;

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

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
