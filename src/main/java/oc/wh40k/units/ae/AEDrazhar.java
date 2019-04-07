package oc.wh40k.units.ae;

import static oc.KeyWord.KABAL;

import oc.Eintrag;

public class AEDrazhar extends Eintrag {

    public AEDrazhar() {
        name = "Drazhar";
        grundkosten = getPts("Drazhar");
        power = 7;

        seperator();

        addWarlordTraits("Hatred Eternal", KABAL);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}