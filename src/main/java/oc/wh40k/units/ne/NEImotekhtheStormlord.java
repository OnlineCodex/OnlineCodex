package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEImotekhtheStormlord extends Eintrag {


    public NEImotekhtheStormlord() {
        name = "Imotekh the Stormlord";
        grundkosten = getPts("Imotekh the Stormlord");
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/NEImotekhderSturmherr.jpg"));

        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
