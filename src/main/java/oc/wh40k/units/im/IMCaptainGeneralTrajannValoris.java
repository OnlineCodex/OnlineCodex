package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMCaptainGeneralTrajannValoris extends Eintrag {
	
    RuestkammerStarter warlord;

    public IMCaptainGeneralTrajannValoris() {
        name = "Captain-General Trajann Valoris";
        grundkosten = getPts("Captain-General Trajann Valoris");
        power = 10;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Champion of the Imperium (AC)");
        add(warlord);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
