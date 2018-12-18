package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMGabrielSeth extends Eintrag {

    public IMGabrielSeth() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, FLESH_TEARERS, CHARACTER, INFANTRY, CHAPTER_MASTER, GABRIEL_SETH);
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

