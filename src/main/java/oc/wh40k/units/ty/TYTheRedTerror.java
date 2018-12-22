package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYTheRedTerror extends Eintrag {
	
    public TYTheRedTerror() {
        name = "The Red Terror";
        grundkosten = getPts("The Red Terror");
        power = 3;
        
		addWarlordTraits("Heightened Senses", true);
		
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
