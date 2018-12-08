package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSkarbrand extends Eintrag {

    public CHSkarbrand() {

        name = "Skarbrand";
        grundkosten = getPts("Skarbrand");
        power = 19;
        
        seperator();
        
        addWarlordTraits("Khorne: Rage Incarnate", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
