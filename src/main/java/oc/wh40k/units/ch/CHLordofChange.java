package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHLordofChange extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHLordofChange() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, MONSTER, FLY, PSYKER, LORD_OF_CHANGE);

        name = "Lord of Change";
        grundkosten = getPts("Lord of Change");
        power = 17;

        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
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
