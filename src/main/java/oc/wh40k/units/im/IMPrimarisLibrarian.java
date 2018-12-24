package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMPrimarisLibrarian extends Eintrag {

    public IMPrimarisLibrarian() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, PRIMARIS, PSYKER, LIBRARIAN);
        name = "Primaris Librarian";
        grundkosten = getPts("Primaris Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        addPsychicPowers(2, getPsychicPowerGroug(checkBuildaVater()));

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
