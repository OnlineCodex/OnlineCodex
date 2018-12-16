package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.KHORNE;

public class CHAnggrathTheUnbound extends Eintrag {

    public CHAnggrathTheUnbound() {

        name = "An'ggrath the Unbound";
        grundkosten = getPts("An'ggrath the Unbound");
        power = 35;
        
        seperator();

        addWarlordTraits("", KHORNE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
