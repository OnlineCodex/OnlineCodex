package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEOrikantheDiviner extends Eintrag {


    public NEOrikantheDiviner() {
        name = "Orikan the Diviner";
        grundkosten = getPts("Orikan the Diviner");
        power = 6;

        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
