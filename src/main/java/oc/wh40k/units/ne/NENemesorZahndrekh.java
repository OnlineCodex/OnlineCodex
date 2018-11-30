package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class NENemesorZahndrekh extends Eintrag {
	
    RuestkammerStarter warlord;

    public NENemesorZahndrekh() {
        name = "Nemesor Zahndrekh";
        grundkosten = getPts("Nemesor Zahndrekh");
        power = 9;
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits)warlord.getKammer()).setPflichtauswahl("Sautekh: Hyperlogical Strategist");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}

