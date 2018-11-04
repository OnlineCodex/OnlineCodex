package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAAunva extends Eintrag {

    public TAAunva() {

        name = "Aun'va";

        grundkosten = getPts("Aun'Va") + 2 * getPts("Ethereal Guard");

        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
        power = 5;
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}