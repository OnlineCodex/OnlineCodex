package oc.wh40k.units.ne;

import oc.Eintrag;

public class NENemesorZahndrekh extends Eintrag {


    public NENemesorZahndrekh() {
        name = "Nemesor Zahndrekh";
        grundkosten = getPts("Nemesor Zahndrekh");
        power = 9;

        seperator();

        addWarlordTraits("Sautekh: Hyperlogical Strategist");

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}

