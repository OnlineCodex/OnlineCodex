package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyChampionwithJumpPack extends Eintrag {
	

    public IMCompanyChampionwithJumpPack() {
        name = "Company Champion with Jump Pack";
        grundkosten = getPts("Company Champion with Jump Pack") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Master-crafted power sword");
        power = 5;
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    public void refreshen() {
    }
}