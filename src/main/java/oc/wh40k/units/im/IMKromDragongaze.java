package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMKromDragongaze extends Eintrag {
	

    public IMKromDragongaze() {
        name = "Krom Dragongaze";
        grundkosten = getPts("Krom Dragongaze");
        power = 6;

        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
