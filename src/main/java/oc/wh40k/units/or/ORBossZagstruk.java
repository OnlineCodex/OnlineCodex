package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORBossZagstruk extends Eintrag {
	
    RuestkammerStarter warlord;

    public ORBossZagstruk() {

        kategorie = 1;
        name = "Boss Zagstruk";
        grundkosten = getPts("Boss Zagstruk");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits) warlord.getKammer()).setPflichtauswahl("Goffs: Proper Killy");
        add(warlord);
        
        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
