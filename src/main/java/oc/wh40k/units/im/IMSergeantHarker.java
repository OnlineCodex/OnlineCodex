package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSergeantHarker extends Eintrag {

    public IMSergeantHarker() {
        name = "Sergeant Harker";
        grundkosten = getPts("Sergeant Harker");
        power = 3;
        
        seperator();

        addWarlordTraits("Catachan: Lead From the Front", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}