package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class NEOrikantheDiviner extends Eintrag {
	

    public NEOrikantheDiviner() {
        name = "Orikan the Diviner";
        grundkosten = getPts("Orikan the Diviner");
        power = 6;
        
        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
