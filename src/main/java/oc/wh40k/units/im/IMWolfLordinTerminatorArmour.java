package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMWolfLordinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffenUndArtefakte;

    public IMWolfLordinTerminatorArmour() {
        name = "Wolf Lord in Terminator Armour";
        grundkosten = getPts("Wolf Lord in Terminator Armour");
        power = 7;
        
        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Wolf Lord in Terminator Armour");
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
