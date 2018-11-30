package oc.wh40k.units.im;

import oc.Eintrag;

public class IMAsmodai extends Eintrag {

    public IMAsmodai() {
        name = "Asmodai";
        grundkosten = getPts("Asmodai");
        power = 7;
        
        seperator();

        addWarlordTraits("Fury of the Lion (DA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}

