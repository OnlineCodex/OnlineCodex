package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMTempestorPrime extends Eintrag {

    RuestkammerStarter kammer;

    public IMTempestorPrime() {
        name = "Tempestor Prime";
        grundkosten = getPts("Tempestor Prime") + getPts("Frag grenade (AM)") + getPts("Krak grenade (AM)");
        power = 2;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, IMAstraMilitarumRuestkammer.class, "");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Temperstor Prime");
        kammer.initKammer();
        kammer.setButtonText("Waffen");
        add(kammer);
        kammer.setAbwaehlbar(false);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}