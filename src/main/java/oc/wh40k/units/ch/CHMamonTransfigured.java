package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.NURGLE;

public class CHMamonTransfigured extends Eintrag {

    public CHMamonTransfigured() {

        name = "Mamon Transfigured";
        grundkosten = getPts("Mamon Transfigured");
        power = 9;
        
        seperator();

        addWarlordTraits("", NURGLE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
