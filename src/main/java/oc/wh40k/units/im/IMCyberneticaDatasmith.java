package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMCyberneticaDatasmith extends Eintrag {
	

    public IMCyberneticaDatasmith() {
        name = "Cybernetica Datasmith";
        grundkosten = getPts("Cybernetica Datasmith") + getPts("Power fist (AME)") + getPts("gamma pistol");
        power = 3;
        
        seperator();

		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
