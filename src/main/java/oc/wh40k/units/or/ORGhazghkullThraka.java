package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORGhazghkullThraka extends Eintrag {


    public ORGhazghkullThraka() {

        kategorie = 1;
        name = "Ghazghkull Thraka";
        grundkosten = getPts("Ghazghkull Thraka");
        power = 12;
        
        seperator();

        addWarlordTraits("Goffs: Proper Killy", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }
}
