package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORMadDokGrotsnik extends Eintrag {

    RuestkammerStarter warlord;
    
    public ORMadDokGrotsnik() {
        name = "Mad Dok Grotsnik";
        kategorie = 1;
        grundkosten = getPts("Mad Dok Grotsnik");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/DokGrotsnik.gif"));

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits) warlord.getKammer()).setPflichtauswahl("Deathskull: Opportunist");
        add(warlord);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }

}
