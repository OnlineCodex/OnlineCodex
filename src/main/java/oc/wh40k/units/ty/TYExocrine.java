package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYExocrine extends Eintrag {

    public TYExocrine() {
        name = "Exocrine";
        grundkosten = getPts("Exocrine") + getPts("Bio-plasmic cannon") + getPts("Powerful limbs");
        power = 11;
        add(ico = new oc.Picture("oc/wh40k/images/TYMorgon.jpg"));
        complete();
    }

    @Override
    public void refreshen() {
    }
}