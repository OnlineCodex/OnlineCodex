package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCommissar extends Eintrag {

    RuestkammerStarter kammer;

    public IMCommissar() {
        name = "Commissar";
        grundkosten = getPts("Commissar");
        power = 2;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, "IMAstraMilitarumRuestkammer", "");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Commissar");
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