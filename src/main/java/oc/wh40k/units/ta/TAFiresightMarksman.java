package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TAFiresightMarksman extends Eintrag {
	
    RuestkammerStarter warlord;

    public TAFiresightMarksman() {
        name = "Firesight Marksman";
        grundkosten = getPts("Firesight Marksman") + getPts("Markerlight") + getPts("Pulse pistol");
        power = 1;
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
    }
}
