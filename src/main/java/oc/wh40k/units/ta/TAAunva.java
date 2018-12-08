package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TAAunva extends Eintrag {
	

    public TAAunva() {
        name = "Aun'va";
        grundkosten = getPts("Aun'Va") + 2 * getPts("Ethereal Guard");
        power = 5;
        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));
        
        seperator();

        addWarlordTraits("Through Unity, Devastation", true);

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}