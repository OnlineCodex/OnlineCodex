package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORZhadsnarkdaRippa extends Eintrag {
	
    RuestkammerStarter warlord;

    public ORZhadsnarkdaRippa() {

        kategorie = 1;
        name = "Zhadsnark da Rippa [FW]";
        grundkosten = getPts("Zhadsnark Da Rippa") + getPts("Da Pain Klaw") + getPts("Slugga") + getPts("Stikkbomm") + getPts("Big shoota") * 2;
        power = 7;

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits) warlord.getKammer()).setPflichtauswahl("Evil Sunz: Speed Freak");
        add(warlord);
        
        complete();
    }

    public void refreshen() {
        setUnikat(true);
    }
}
