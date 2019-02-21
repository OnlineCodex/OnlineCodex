package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMChiefLibrarianMephiston extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public IMChiefLibrarianMephiston() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, INFANTRY, LIBRARIAN, PSYKER, CHIEF_LIBRARIAN_MEPHISTON);
        name = "Chief Librarian Mephiston";
        grundkosten = getPts("Chief Librarian Mephiston");
        power = 8;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("Selfless Valour (BA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
