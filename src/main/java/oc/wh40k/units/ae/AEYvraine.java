package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEYvraine extends Eintrag {

    public AEYvraine() {
        name = "Yvraine";
        grundkosten = getPts("Yvraine");
        power = 7;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}