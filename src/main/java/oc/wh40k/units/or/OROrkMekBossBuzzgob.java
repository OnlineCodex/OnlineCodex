package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class OROrkMekBossBuzzgob extends Eintrag {

    
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
        
        addWarlordTraits("Goffs: Proper Killy", true);
        
        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
