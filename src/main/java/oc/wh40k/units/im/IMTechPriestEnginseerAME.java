package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMTechPriestEnginseerAME extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMTechPriestEnginseerAME() {
        name = "Tech-Priest Enginseer";
        grundkosten = getPts("Tech-Priest Enginseer (AME)") + getPts("Omnissian axe") + getPts("Laspistol (AME)") + getPts("Servo-arm (AME)");
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
