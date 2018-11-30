package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TACommanderFarsight extends Eintrag {
	
    RuestkammerStarter warlord;

    public TACommanderFarsight() {
        name = "Commander Farsight";
        grundkosten = getPts("Commander Farsight");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/OShovah.gif"));
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Farsight Enclaves: Hero of the Enclaves");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
