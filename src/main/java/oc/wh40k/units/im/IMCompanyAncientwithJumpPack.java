package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyAncientwithJumpPack extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMCompanyAncientwithJumpPack() {
        name = "Company Ancient with Jump Pack";
        grundkosten = getPts("Company Ancient with Jump Pack") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 5;
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Company Ancient");
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
