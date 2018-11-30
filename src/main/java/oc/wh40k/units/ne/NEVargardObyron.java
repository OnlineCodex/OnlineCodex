package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NEVargardObyron extends Eintrag {
	
    RuestkammerStarter warlord;

    public NEVargardObyron() {
        name = "Vargard Obyron";
        grundkosten = getPts("Vargard Obyron");
        power = 7;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Sautekh: Hyperlogical Strategist");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
