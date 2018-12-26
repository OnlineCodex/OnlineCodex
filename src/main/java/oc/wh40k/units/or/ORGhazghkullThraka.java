package oc.wh40k.units.or;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORGhazghkullThraka extends Eintrag {


    public ORGhazghkullThraka() {
        name = "Ghazghkull Thraka";
        grundkosten = getPts("Ghazghkull Thraka");
        power = 12;
        
        seperator();

        addWarlordTraits("Goffs: Proper Killy", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
