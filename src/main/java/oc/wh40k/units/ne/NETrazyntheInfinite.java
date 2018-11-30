package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NETrazyntheInfinite extends Eintrag {

    RuestkammerStarter warlord;

    public NETrazyntheInfinite() {
        name = "Trazyn the Infinite";
        grundkosten = getPts("Trazyn the Infinite");
        power = 5;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Nihilakh: Precognitive Strike");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
