package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyChampion extends Eintrag {
	

    public IMCompanyChampion() {
        name = "Company Champion";
        grundkosten = getPts("Company Champion") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Combat shield");

        if (buildaVater.getFormationType().equals("Dark Angels")) {
            grundkosten += getPts("Blade of Caliban");
        } else {
            grundkosten += getPts("Master-crafted power sword");
        }

        power = 3;
        
        seperator();

		addWarlordTraits("", true);


        complete();
    }

    public void refreshen() {
    }
}