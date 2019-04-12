package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.EXALTED_SORCERER;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.SORCERER;
import static oc.KeyWord.THOUSAND_SONS;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHExaltedSorcerer extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHExaltedSorcerer() {
    	super(CHAOS, HERETIC_ASTARTES, THOUSAND_SONS, TZEENTCH, CHARACTER, INFANTRY, SORCERER, EXALTED_SORCERER);

        name = "Exalted Sorcerer";
        grundkosten = getPts("Exalted Sorcerer");
        power = 7;

        seperator();

        addWeapons(CHThousandSonsRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("");

        complete();
    }
}
