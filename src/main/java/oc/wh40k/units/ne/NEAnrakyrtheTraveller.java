package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NEAnrakyrtheTraveller extends Eintrag {

    RuestkammerStarter warlord;

    public NEAnrakyrtheTraveller() {
        name = "Anrakyr the Traveller";
        grundkosten = getPts("Anrakyr the Traveller");
        power = 9;
        
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
        setUnikat(true);
    }

}
