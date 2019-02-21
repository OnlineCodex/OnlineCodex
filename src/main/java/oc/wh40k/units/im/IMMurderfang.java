package oc.wh40k.units.im;

import oc.Eintrag;

public class IMMurderfang extends Eintrag {

    public IMMurderfang() {
        name = "Murderfang";
        grundkosten = getPts("Murderfang");
        power = 9;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
