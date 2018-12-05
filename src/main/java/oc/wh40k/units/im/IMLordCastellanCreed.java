package oc.wh40k.units.im;

import oc.Eintrag;

public class IMLordCastellanCreed extends Eintrag {

    public IMLordCastellanCreed() {
        name = "Lord Castellan Creed";
        grundkosten = getPts("Lord Castellan Creed");
        power = 4;
        
        seperator();

        addWarlordTraits("Cadian: Superior Tactical Training", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}