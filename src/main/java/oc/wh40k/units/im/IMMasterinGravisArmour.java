package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMMasterinGravisArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMMasterinGravisArmour() {
        name = "Master in Gravis Armour";
        grundkosten = getPts("Master in Gravis Armour") + getPts("Master-crafted power sword") + getPts("Boltstorm gauntlet");
        power = 7;
        
        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Master in Gravis Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
