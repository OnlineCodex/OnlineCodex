package oc.wh40k.units.im;

import oc.Eintrag;

public class IMNorkDeddog extends Eintrag {

    public IMNorkDeddog() {
        name = "Nork Deddog";
        grundkosten = getPts("Nork Deddog");
        power = 4;
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}