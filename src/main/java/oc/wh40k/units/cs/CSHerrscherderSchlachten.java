package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSHerrscherderSchlachten extends Eintrag {

    public CSHerrscherderSchlachten() {
        name = "Herrscher der Schlachten";
        grundkosten = 750;

        add(ico = new oc.Picture("oc/wh40k/images/HerrscherderSchlachten.gif"));


        complete();

    }

    public void refreshen() {
        setUnikat(true);
    }
}
