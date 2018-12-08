package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYTheRedTerror extends Eintrag {
	

    public TYTheRedTerror() {
        name = "The Red Terror";
        grundkosten = getPts("The Red Terror");
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/TYBroodlord.jpg"));
        complete();

        seperator();
        
		addWarlordTraits("", true);
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
