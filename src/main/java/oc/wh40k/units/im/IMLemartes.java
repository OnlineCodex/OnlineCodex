package oc.wh40k.units.im;

import oc.Eintrag;

public class IMLemartes extends Eintrag {

    public IMLemartes() {
        name = "Lemartes";
        grundkosten = getPts("Lemartes");
        power = 7;
        seperator();
        complete();
    }

    @Override
    public void refreshen() {
        this.setUnikat(true);
    }
}
