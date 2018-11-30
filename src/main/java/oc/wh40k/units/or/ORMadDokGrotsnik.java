package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORMadDokGrotsnik extends Eintrag {

    
    public ORMadDokGrotsnik() {
        name = "Mad Dok Grotsnik";
        kategorie = 1;
        grundkosten = getPts("Mad Dok Grotsnik");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/DokGrotsnik.gif"));

        seperator();
        
        addWarlordTraits("Deathskull: Opportunist", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }

}
