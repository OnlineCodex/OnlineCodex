package oc.wh40k.units.im;

import oc.Eintrag;

public class IMBjorntheFellHanded extends Eintrag {


    public IMBjorntheFellHanded() {
        name = "Bjorn the Fellhanded";
        grundkosten = getPts("Bjorn the Fellhanded");
        power = 14;

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
