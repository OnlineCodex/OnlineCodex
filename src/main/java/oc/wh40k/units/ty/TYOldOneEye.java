package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TYOldOneEye extends Eintrag {
	
    RuestkammerStarter warlord;

    public TYOldOneEye() {
        name = "Old One Eye";
        grundkosten = getPts("OldOneEye");
        power = 7;
        add(ico = new oc.Picture("oc/wh40k/images/TYDerSchwarmherrscher.jpg"));
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
