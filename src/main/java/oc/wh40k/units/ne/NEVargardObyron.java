package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEVargardObyron extends Eintrag {


    public NEVargardObyron() {
        name = "Vargard Obyron";
        grundkosten = getPts("Vargard Obyron");
        power = 7;

        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
