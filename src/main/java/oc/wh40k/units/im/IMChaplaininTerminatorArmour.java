package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMChaplaininTerminatorArmour extends Eintrag {
    RuestkammerStarter waffenUndReliquien;

    public IMChaplaininTerminatorArmour() {
        name = "Chaplain in Terminator Armour";
        grundkosten = getPts("Chaplain in Terminator Armour") + getPts("Crozius arcanum");
        power = 6;
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Chaplain in Terminator Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }
}