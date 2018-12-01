package oc.wh40k.units.im;

import oc.Eintrag;

public class IMKayvaanShrike extends Eintrag {

    public IMKayvaanShrike() {
        name = "Kayvaan Shrike";
        grundkosten = getPts("Kayvaan Shrike");
        power = 8;
        
        seperator();

        addWarlordTraits("Raven Guard: Silent Stalker", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}