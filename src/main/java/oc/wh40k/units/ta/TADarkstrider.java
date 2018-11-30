package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TADarkstrider extends Eintrag {
	
    RuestkammerStarter warlord;

    public TADarkstrider() {
        name = "Darkstrider";
        grundkosten = getPts("Darkstrider");
        power = 3;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("A Ghost Walks Among Us");
        add(warlord);

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
