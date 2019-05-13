package oc.wh40k.units.ch;

import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.FLY;
import static oc.KeyWord.HORROR;
import static oc.KeyWord.THE_BLUE_SCRIBES;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTheBlueScribes extends Eintrag {

	private final RuestkammerStarter psychicPowers;
	
    public CHTheBlueScribes() {
        super(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, THE_BLUE_SCRIBES);

        name = "The Blue Scribes";
        grundkosten = getPts("The Blue Scribes");
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

        addWarlordTraits("Tzeentch: Daemonspark", TZEENTCH);

        complete();
    }

    @Override
    public void refreshen() {
    	setUnikat(true);
    }
}
