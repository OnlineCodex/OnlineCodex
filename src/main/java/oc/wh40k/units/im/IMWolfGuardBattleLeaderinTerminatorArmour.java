package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeaderinTerminatorArmour extends Eintrag {

    public IMWolfGuardBattleLeaderinTerminatorArmour() {
        name = "Wolf Guard Battle Leader in Terminator Armour";
        grundkosten = getPts("Wolf Guard Battle Leader in Terminator Armour");
        power = 6;
        seperator();

        RuestkammerStarter waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Guard Battle Leader in Terminator Armour");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }
}
