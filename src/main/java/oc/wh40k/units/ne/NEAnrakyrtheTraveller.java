package oc.wh40k.units.ne;

import oc.Eintrag;

public class NEAnrakyrtheTraveller extends Eintrag {


    public NEAnrakyrtheTraveller() {
        name = "Anrakyr the Traveller";
        grundkosten = getPts("Anrakyr the Traveller");
        power = 9;

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}
