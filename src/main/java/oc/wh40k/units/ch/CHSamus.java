package oc.wh40k.units.ch;

import static oc.KeyWord.KHORNE;

import oc.Eintrag;

public class CHSamus extends Eintrag {

    public CHSamus() {

        name = "Samus";
        grundkosten = getPts("Samus");
        power = 12;

        seperator();

        addWarlordTraits("", KHORNE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
