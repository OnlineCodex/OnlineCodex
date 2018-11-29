package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TYDeathleaper extends Eintrag {

    RuestkammerStarter warlord;
    
    public TYDeathleaper() {
        name = "Deathleaper(";
        grundkosten = getPts("Deathleaper");
        power = 4;
        add(ico = new oc.Picture("oc/wh40k/images/TYTodeshetzer.jpg"));
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