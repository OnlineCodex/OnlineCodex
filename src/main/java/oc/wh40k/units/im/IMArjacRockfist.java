package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMArjacRockfist extends Eintrag {
    
	RuestkammerStarter warlord;

    public IMArjacRockfist() {
        name = "Arjac Rockfist";
        grundkosten = getPts("Arjac Rockfist");
        power = 7;

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
