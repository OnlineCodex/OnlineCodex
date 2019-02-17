package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianDreadnought extends Eintrag {

	private final OptionsUpgradeGruppe o2;
	private final RuestkammerStarter psychicPowers;

    public IMLibrarianDreadnought() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, BLOOD_ANGELS, CHARACTER, VEHICLE, DREADNOUGHT, LIBRARIAN, PSYKER, LIBRARIAN_DREADNOUGHT);
        name = "Librarian Dreadnought";
        grundkosten = getPts("Librarian Dreadnought") + getPts("Furioso force halberd") + getPts("Furioso fist (single)");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", "Storm bolter", getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", "Heavy flamer", getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWeapons(IMSpaceMarinesRuestkammer.class, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSanguinary();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
