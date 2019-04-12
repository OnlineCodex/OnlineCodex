package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAAunva extends Eintrag {


    public TAAunva() {
        name = "Aun'va";
        grundkosten = getPts("Aun'Va") + 2 * getPts("Ethereal Guard");
        power = 5;
        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));

        seperator();

        addWarlordTraits("Through Unity, Devastation");

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}