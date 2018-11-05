package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMAhazraRedth extends Eintrag {
    //TODO Mantis Warriors only
    public SMAhazraRedth() {
        name = "Ahazra Redth";
        grundkosten = 165;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
