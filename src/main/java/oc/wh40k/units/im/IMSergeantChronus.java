package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSergeantChronus extends Eintrag {

    public IMSergeantChronus() {
        name = "Sergeant Chronus";
        grundkosten = getPts("Sergeant Chronus");
        power = 3;

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
