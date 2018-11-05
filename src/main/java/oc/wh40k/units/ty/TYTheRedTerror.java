package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYTheRedTerror extends Eintrag {

    public TYTheRedTerror() {
        name = "The Red Terror";
        grundkosten = getPts("The Red Terror");
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/TYBroodlord.jpg"));
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
