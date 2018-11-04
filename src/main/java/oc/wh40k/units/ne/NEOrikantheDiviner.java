package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEOrikantheDiviner extends Eintrag {

    public NEOrikantheDiviner() {
        name = "Orikan the Diviner";
        grundkosten = getPts("Orikan the Diviner");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        power = 6;
    }
}
