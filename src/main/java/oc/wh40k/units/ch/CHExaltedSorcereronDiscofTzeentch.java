package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.EXALTED_SORCERER;
import static oc.KeyWord.HERETIC_ASTARTES;
import static oc.KeyWord.CAVALRY;
import static oc.KeyWord.SORCERER;
import static oc.KeyWord.THOUSAND_SONS;
import static oc.KeyWord.TZEENTCH;
import static oc.KeyWord.FLY;
import static oc.KeyWord.DAEMON;

import oc.Eintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHExaltedSorcereronDiscofTzeentch extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHExaltedSorcereronDiscofTzeentch() {
    	super(CHAOS, HERETIC_ASTARTES, THOUSAND_SONS, TZEENTCH, CHARACTER, CAVALRY, SORCERER, EXALTED_SORCERER, DAEMON, FLY);
    	
        name = "Exalted Sorcerer on Disk";
        grundkosten = getPts("Exalted Sorcerer on Disc of Tzeentch");
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

        addWarlordTraits("", true);

        complete();
    }
}
