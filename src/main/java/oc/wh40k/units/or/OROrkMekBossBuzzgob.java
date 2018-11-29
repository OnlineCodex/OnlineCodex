package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class OROrkMekBossBuzzgob extends Eintrag {

    RuestkammerStarter warlord;
    
    public OROrkMekBossBuzzgob() {
        name = "Ork Mek Boss Buzzgob";
        grundkosten = getPts("Ork Mek Boss Buzzgob") +
                getPts("slugga") +
                getPts("big choppa") +
                getPts("stikkbomms") +
                getPts("Mek arms") +
                getPts("Nitnuckle") +
                getPts("Lunk");

        power = 6;

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
