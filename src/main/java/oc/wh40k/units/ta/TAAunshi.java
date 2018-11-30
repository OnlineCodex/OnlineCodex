package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TAAunshi extends Eintrag {
	
    RuestkammerStarter warlord;

    public TAAunshi() {
        name = "Aun'shi";
        grundkosten = getPts("Aun'Shi");
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Vior'la: Academy Luminary");
        add(warlord);

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}