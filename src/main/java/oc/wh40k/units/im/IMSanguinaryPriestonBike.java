package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMSanguinaryPriestonBike extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMSanguinaryPriestonBike() {
        name = "Sanguinary Priest on Bike";
        grundkosten = getPts("Sanguinary Priest on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 6;

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Sanguinary Priest");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
