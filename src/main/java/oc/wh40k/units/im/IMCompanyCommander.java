package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCompanyCommander extends Eintrag {

    RuestkammerStarter kammer;

    public IMCompanyCommander() {
        name = "Company Commander";
        grundkosten = getPts("Company Commander") + getPts("Frag grenade (AM)");
        power = 3;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, IMAstraMilitarumRuestkammer.class, "");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Company Commander");
        kammer.initKammer();
        kammer.setButtonText("Waffen");
        add(kammer);
        kammer.setAbwaehlbar(false);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
    }
}