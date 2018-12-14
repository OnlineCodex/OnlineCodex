package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHSamus extends Eintrag {

    public CHSamus() {

        name = "Samus";
        grundkosten = getPts("Samus");
        power = 12;
        
        seperator();

        addWarlordTraits("", true, KHORNE);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
