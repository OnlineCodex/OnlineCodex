package oc.wh40k.units.im;

import oc.*;

public class IMWolfGuardBattleLeader extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter waffenUndArtefakte;

    public IMWolfGuardBattleLeader() {
        name = "Wolf Guard Battle Leader";
        grundkosten = getPts("Wolf Guard Battle Leader");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Guard Battle Leader with Jump Pack") - getPts("Wolf Guard Battle Leader")));

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
        power = 4;
        if (oe1.isSelected()) {
            power += 1;
        }
    }

}
