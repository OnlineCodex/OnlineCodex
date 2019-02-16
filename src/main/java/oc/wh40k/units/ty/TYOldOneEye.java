package oc.wh40k.units.ty;

import oc.Eintrag;

public class TYOldOneEye extends Eintrag {
	

    public TYOldOneEye() {
        name = "Old One Eye";
        grundkosten = getPts("OldOneEye");
        power = 7;
        
		addWarlordTraits("Adaptive Biology", true);
		
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
