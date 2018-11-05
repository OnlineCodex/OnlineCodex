package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMMasterinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffenUndReliquien;

    public IMMasterinTerminatorArmour() {
        name = "Master in Terminator Armour";
        grundkosten = getPts("Master in Terminator Armour");
        power = 7;

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceMarinesRuestkammer", "");
        ((IMSpaceMarinesRuestkammer) waffenUndReliquien.getKammer()).setType("Captain in Terminator Armour");
        waffenUndReliquien.initKammer();
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
