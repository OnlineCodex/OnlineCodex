package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHNecrosiustheUndying extends Eintrag {

    public CHNecrosiustheUndying() {

        name = "Necrosius the Undying";
        grundkosten = getPts("Necrosius the Undying") + 
        			  getPts("tainted force blade") + 
        			  getPts("pox pistol") +
        			  getPts("blight grenades") +
        			  getPts("krak grenades");
        power = 7;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
