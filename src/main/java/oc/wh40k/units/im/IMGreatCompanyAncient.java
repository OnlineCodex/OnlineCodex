package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMGreatCompanyAncient extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;

    public IMGreatCompanyAncient() {
        name = "Great Company Ancient";
        grundkosten = getPts("Great Company Ancient") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 4;
        
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndReliquien.getKammer()).setType("Great Company Ancient");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
