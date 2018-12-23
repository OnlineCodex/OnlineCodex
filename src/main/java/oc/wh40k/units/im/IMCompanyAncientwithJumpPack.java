package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyAncientwithJumpPack extends Eintrag {

    public IMCompanyAncientwithJumpPack() {
        name = "Company Ancient with Jump Pack";
        grundkosten = getPts("Company Ancient with Jump Pack") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 5;
        seperator();

        IMSpaceMarinesRuestkammer kammer = new IMSpaceMarinesRuestkammer("Company Ancient", getKeywords());
        kammer.jump = true;
        RuestkammerStarter waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, kammer);
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        waffenUndReliquien.setAbwaehlbar(false);
        add(waffenUndReliquien);

        complete();
    }
}
