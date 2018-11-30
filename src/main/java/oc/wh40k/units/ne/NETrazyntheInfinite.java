package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class NETrazyntheInfinite extends Eintrag {


    public NETrazyntheInfinite() {
        name = "Trazyn the Infinite";
        grundkosten = getPts("Trazyn the Infinite");
        power = 5;
        
        seperator();

        addWarlordTraits("Nihilakh: Precognitive Strike", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
