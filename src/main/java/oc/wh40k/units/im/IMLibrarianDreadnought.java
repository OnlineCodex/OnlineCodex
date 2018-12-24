package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANGUINARY;

public class IMLibrarianDreadnought extends Eintrag {

    public IMLibrarianDreadnought() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, VEHICLE, DREADNOUGHT, LIBRARIAN, PSYKER, LIBRARIAN_DREADNOUGHT);
        name = "Librarian Dreadnought";
        grundkosten = getPts("Librarian Dreadnought") + getPts("Furioso force halberd") + getPts("Furioso fist (single)");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", "Storm bolter", getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", "Heavy flamer", getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        seperator();

        addPsychicPowers(2, SANGUINARY);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
