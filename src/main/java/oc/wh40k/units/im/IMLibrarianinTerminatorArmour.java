package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianinTerminatorArmour extends Eintrag {

    public IMLibrarianinTerminatorArmour() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, INFANTRY, TERMINATOR, PSYKER, LIBRARIAN);
        name = "Librarian in Terminator Armour";
        grundkosten = getPts("Librarian in Terminator Armour");
        power = 8;

        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        seperator();

        addPsychicPowers(2, getPsychicPowerGroug(checkBuildaVater()));

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
