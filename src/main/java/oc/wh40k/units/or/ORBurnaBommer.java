package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORBurnaBommer extends Eintrag {

    public ORBurnaBommer() {
        name = "Burna-Bommer";
        grundkosten = getPts("Burna-Bommer") + getPts("supa shoota")*2 + getPts("Twin big shoota");
        power = 7;

        add(ico = new oc.Picture("oc/wh40k/images/BrennaBomma.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Skorcha missiles", getPts("Skorcha missile")));

        complete();

    }
}
