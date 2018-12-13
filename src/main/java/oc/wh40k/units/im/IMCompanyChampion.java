package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyChampion extends Eintrag {
	RuestkammerStarter waffenUndReliquien;

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
            
            seperator();

            waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
            ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Company Champion");
            waffenUndReliquien.initKammer();
            waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
            add(waffenUndReliquien);
            waffenUndReliquien.setAbwaehlbar(false);
        }

        power = 3;
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}