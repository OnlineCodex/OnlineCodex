package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class ORBossSnikrot extends Eintrag {

    RuestkammerStarter warlord;

    public ORBossSnikrot() {

        kategorie = 1;
        name = "Boss Snikrot";
        grundkosten = getPts("Boss Snikrot");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        ((Warlordtraits) warlord.getKammer()).setPflichtauswahl("Blood Axes: I've got a plan, Ladz");
        add(warlord);
        
        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
