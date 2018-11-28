package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMLordCommissar extends Eintrag {

    RuestkammerStarter kammer;

    public IMLordCommissar() {
        name = "Lord Commissar";
        grundkosten = getPts("Lord Commissar");
        power = 4;

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, IMAstraMilitarumRuestkammer.class, "");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Lord Commissar");
        kammer.initKammer();
        kammer.setButtonText("Waffen");
        add(kammer);
        kammer.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}