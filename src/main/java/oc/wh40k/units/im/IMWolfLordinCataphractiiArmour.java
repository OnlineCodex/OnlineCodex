package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMWolfLordinCataphractiiArmour extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;

    public IMWolfLordinCataphractiiArmour() {
        name = "Wolf Lord in Cataphractii Armour";
        grundkosten = getPts("Wolf Lord in Cataphractii Armour");
        power = 8;
        
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Lord in Cataphractii Armour");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }
}
