package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMTechmarine extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMTechmarine() {
        name = "Techmarine";
        grundkosten = getPts("Techmarine") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();


        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Techmarine");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4 + (((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).oe1.isSelected() ? 1 : 0);
    }
}
