package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSWeltuntergangsmaschine extends Eintrag {

    public CSWeltuntergangsmaschine() {
        name = "Weltuntergangsmaschine";
        grundkosten = 400;

        add(ico = new oc.Picture("oc/wh40k/images/CMWeltuntergangsmaschine.gif"));


        complete();

    }

    public void refreshen() {
    }
}
