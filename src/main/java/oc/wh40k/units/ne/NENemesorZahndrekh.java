package oc.wh40k.units.ne;

import oc.Eintrag;

public class NENemesorZahndrekh extends Eintrag {

    public NENemesorZahndrekh() {
        name = "Nemesor Zahndrekh";
        grundkosten = getPts("Nemesor Zahndrekh");
        power = 9;

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
