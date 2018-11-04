package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHMamonTransfigured extends Eintrag {

    public CHMamonTransfigured() {

        name = "Mamon Transfigured";
        grundkosten = getPts("Mamon Transfigured");
        power = 9;

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
