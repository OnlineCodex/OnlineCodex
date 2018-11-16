package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeaderonThunderwolf extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;

    public IMWolfGuardBattleLeaderonThunderwolf() {
        name = "Wolf Guard Battle Leader on Thunderwolf";
        grundkosten = getPts("Wolf Guard Battle Leader on Thunderwolf");
        power = 6;
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Guard Battle Leader");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
