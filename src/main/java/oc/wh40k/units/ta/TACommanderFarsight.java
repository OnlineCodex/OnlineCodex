package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TACommanderFarsight extends Eintrag {
	

    public TACommanderFarsight() {
        name = "Commander Farsight";
        grundkosten = getPts("Commander Farsight");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/OShovah.gif"));
        
        seperator();

        addWarlordTraits("Farsight Enclaves: Hero of the Enclaves", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
