package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMHaraldDeathwolf extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMHaraldDeathwolf() {
        name = "Harald Deathwolf";
        grundkosten = getPts("Harald Deathwolf");
        power = 10;

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
