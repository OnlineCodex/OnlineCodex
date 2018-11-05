package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEVargardObyron extends Eintrag {

    public NEVargardObyron() {
        name = "Vargard Obyron";
        grundkosten = getPts("Vargard Obyron");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        power = 7;
    }
}
