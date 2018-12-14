package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCaptainonBike extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMCaptainonBike() {
        name = "Captain on Bike";
        grundkosten = getPts("Captain on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Twin boltgun");
        power = 7;

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Captain on Bike");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}
