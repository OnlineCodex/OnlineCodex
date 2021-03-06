package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_ASTARTES;
import static oc.KeyWord.BLOOD_ANGELS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CHIEF_LIBRARIAN_MEPHISTON;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.LIBRARIAN;
import static oc.KeyWord.PSYKER;

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
