package oc.wh40k.units.im;

import oc.Eintrag;

public class IMGabrielSeth extends Eintrag {

    public IMGabrielSeth() {
        name = "Gabriel Seth";
        grundkosten = getPts("Gabriel Seth");
        power = 7;
        
        seperator();
        
        addWarlordTraits("Selfless Valour (BA)", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}

