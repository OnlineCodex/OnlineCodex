package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORGhazghkullThraka extends Eintrag {

    RuestkammerStarter warlord;

    public ORGhazghkullThraka() {

        kategorie = 1;
        name = "Ghazghkull Thraka";
        grundkosten = getPts("Ghazghkull Thraka");
        power = 12;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits) warlord.getKammer()).setPflichtauswahl("Goffs: Proper Killy");
        add(warlord);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
