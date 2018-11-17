package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMGreatCompanyChampion extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;

    public IMGreatCompanyChampion() {
        name = "Great Company Champion";
        grundkosten = getPts("Great Company Champion") + getPts("bolt pistol (SM)") +  getPts("master crafted power sword") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 3;
        
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
        ((IMSpaceWolvesRuestkammer) waffenUndReliquien.getKammer()).setType("Great Company Champion");
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
