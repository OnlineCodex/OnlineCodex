package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.LIBRARIUS;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMChiefLibrarianTigurius extends Eintrag {

    public IMChiefLibrarianTigurius() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, ULTRAMARINES, CHARACTER, INFANTRY, LIBRARIAN, PSYKER, TIGURIUS);
        name = "Chief Librarian Tigurius";
        grundkosten = getPts("Chief Librarian Tigurius");
        power = 7;

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(3, LIBRARIUS), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
