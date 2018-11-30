package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMTechPriestEnginseer extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMTechPriestEnginseer() {
        name = "Tech-Priest Enginseer";
        grundkosten = getPts("Tech-Priest Enginseer (AM)") + getPts("Omnissian axe") + getPts("Laspistol (AME)") + getPts("Servo-arm (AME)");
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
