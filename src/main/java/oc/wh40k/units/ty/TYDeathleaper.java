package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYDeathleaper extends Eintrag {

    
    public TYDeathleaper() {
        name = "Deathleaper(";
        grundkosten = getPts("Deathleaper");
        power = 4;
        add(ico = new oc.Picture("oc/wh40k/images/TYTodeshetzer.jpg"));
        complete();

        seperator();
        
		addWarlordTraits("", true);
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}