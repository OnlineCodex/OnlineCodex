package oc.wh40k.units.im;

import oc.Eintrag;

public class IMArjacRockfist extends Eintrag {

    public IMArjacRockfist() {
        name = "Arjac Rockfist";
        grundkosten = getPts("Arjac Rockfist");
        power = 7;

        seperator();

		addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }

}
