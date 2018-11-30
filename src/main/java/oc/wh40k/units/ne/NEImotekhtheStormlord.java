package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NEImotekhtheStormlord extends Eintrag {
	
    RuestkammerStarter warlord;

    public NEImotekhtheStormlord() {
        name = "Imotekh the Stormlord";
        grundkosten = getPts("Imotekh the Stormlord");
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/NEImotekhderSturmherr.jpg"));
        
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
