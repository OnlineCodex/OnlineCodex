package oc.wh40k.units.im;

import oc.*;

public class IMWolfLordonThunderwolf extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;

    public IMWolfLordonThunderwolf() {
        name = "Wolf Lord on Thunderwolf";
        grundkosten = getPts("Wolf Lord on Thunderwolf");
        power = 7;

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Lord on Thunderwolf");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }
}
