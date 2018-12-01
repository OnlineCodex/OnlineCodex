package oc.wh40k.units.im;

import oc.Eintrag;

public class IMSergeantTelion extends Eintrag {

    public IMSergeantTelion() {
        name = "Sergeant Telion";
        grundkosten = getPts("Sergeant Telion");
        power = 5;
        
        seperator();

        addWarlordTraits("Ultramarines: Adept of the Codex", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
