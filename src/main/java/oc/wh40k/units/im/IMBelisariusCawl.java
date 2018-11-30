package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMBelisariusCawl extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMBelisariusCawl() {
        name = "Belisarius Cawl";
        grundkosten = getPts("Belisarius Cawl");
        power = 13;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Mars: Static Psalm-code (AdMech)");
        add(warlord);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
