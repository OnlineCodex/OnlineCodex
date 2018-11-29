package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMLoganGrimnaronStormrider extends Eintrag {

    RuestkammerStarter warlord;

    public IMLoganGrimnaronStormrider() {
        name = "Logan Grimnar on Stormrider";
        grundkosten = getPts("Logan Grimnar on Stormrider");
        power = 12;

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
