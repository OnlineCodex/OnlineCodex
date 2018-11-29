package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TYTheRedTerror extends Eintrag {
	
    RuestkammerStarter warlord;

    public TYTheRedTerror() {
        name = "The Red Terror";
        grundkosten = getPts("The Red Terror");
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/TYBroodlord.jpg"));
        complete();

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
