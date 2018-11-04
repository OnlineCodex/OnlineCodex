package oc.wh40k.units.ae;

import oc.Eintrag;

public class AEAsurmen extends Eintrag {

    public AEAsurmen() {
        name = "Asurmen";
        grundkosten = getPts("Asurmen");
        power = 9;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}