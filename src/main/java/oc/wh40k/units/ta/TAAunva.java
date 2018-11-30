package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TAAunva extends Eintrag {
	
    RuestkammerStarter warlord;

    public TAAunva() {
        name = "Aun'va";
        grundkosten = getPts("Aun'Va") + 2 * getPts("Ethereal Guard");
        power = 5;
        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Through Unity, Devastation");
        add(warlord);

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}