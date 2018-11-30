package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCyberneticaDatasmith extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMCyberneticaDatasmith() {
        name = "Cybernetica Datasmith";
        grundkosten = getPts("Cybernetica Datasmith") + getPts("Power fist (AME)") + getPts("gamma pistol");
        power = 3;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);
        
        complete();
    }

    @Override
    public void refreshen() {
    }
}
