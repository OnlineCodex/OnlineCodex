package oc.wh40k.units.or;

import oc.Eintrag;

public class ORBossZagstruk extends Eintrag {
	

    public ORBossZagstruk() {

        name = "Boss Zagstruk";
        grundkosten = getPts("Boss Zagstruk");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();
        
        addWarlordTraits("Goffs: Proper Killy", true);
        
        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
