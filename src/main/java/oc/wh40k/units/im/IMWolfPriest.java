package oc.wh40k.units.im;

import oc.*;

public class IMWolfPriest extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter waffenUndArtefakte;

    public IMWolfPriest() {
        name = "Wolf Priest";
        grundkosten = getPts("Wolf Priest") + getPts("crozius arcanum");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Priest with Jump Pack") - getPts("Wolf Priest")));

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Priest");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5;
        if (oe1.isSelected()) {
            power += 1;
        }
    }

}
