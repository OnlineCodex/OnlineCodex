package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.TZEENTCH;

public class CHAetaosraukeres extends Eintrag {

    public CHAetaosraukeres() {

        name = "Aetaos'rau'keres";
        grundkosten = getPts("Aetaos'rau'keres");
        power = 35;
        
        seperator();

        addWarlordTraits("", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
