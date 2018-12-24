package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANGUINARY;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMChiefLibrarianMephiston extends Eintrag {

    public IMChiefLibrarianMephiston() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, LIBRARIAN, PSYKER, CHIEF_LIBRARIAN_MEPHISTON);
        name = "Chief Librarian Mephiston";
        grundkosten = getPts("Chief Librarian Mephiston");
        power = 8;

        seperator();

        addPsychicPowers(3, SANGUINARY);
        
        seperator();
        
        addWarlordTraits("Selfless Valour (BA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
