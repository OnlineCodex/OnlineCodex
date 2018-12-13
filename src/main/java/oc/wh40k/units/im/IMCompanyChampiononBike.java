package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyChampiononBike extends Eintrag {
	RuestkammerStarter waffenUndReliquien;
	

    public IMCompanyChampiononBike() {
        name = "Company Champion on Bike";
        grundkosten = getPts("Company Champion on Bike") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)") +
                getPts("Master-crafted power sword") +
                getPts("Twin boltgun");
        power = 5;
        
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Company Champion");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}