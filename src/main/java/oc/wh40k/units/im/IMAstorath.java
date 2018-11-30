package oc.wh40k.units.im;

import oc.Eintrag;

public class IMAstorath extends Eintrag {

    public IMAstorath() {
        name = "Astorath";
        grundkosten = getPts("Astorath");
        power = 8;
        seperator();
        
        addWarlordTraits("Soulwarden (BA)", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        this.setUnikat(true);
    }
}
