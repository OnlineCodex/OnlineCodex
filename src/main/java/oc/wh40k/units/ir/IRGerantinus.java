package oc.wh40k.units.ir;

import oc.Eintrag;

public class IRGerantinus extends Eintrag {

    public IRGerantinus() {
        name = "Gerantinus";
        grundkosten = 500;

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
    }

}
