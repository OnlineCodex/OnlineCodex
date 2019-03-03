package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianinPhobosArmour extends Eintrag {
	private final RuestkammerStarter psychicPowers;

    public IMLibrarianinPhobosArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PSYKER, LIBRARIAN);
        name = "Librarian in Phobos Armour";
        grundkosten = getPts("Librarian in Phobos Armour") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)" + getPts("Camo cloak"));

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableObscuration();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
    }
}