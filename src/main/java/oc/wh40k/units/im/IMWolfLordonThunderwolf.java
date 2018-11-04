package oc.wh40k.units.im;

import oc.*;

public class IMWolfLordonThunderwolf extends Eintrag {

    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean fenrisSupp = false;

    public IMWolfLordonThunderwolf() {
        name = "Wolf Lord on Thunderwolf";
        grundkosten = getPts("Wolf Lord on Thunderwolf");
        power = 8;

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Lord");
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
