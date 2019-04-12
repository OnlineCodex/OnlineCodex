package oc.wh40k.units.or;

import oc.Eintrag;

public class ORBossZagstruk extends Eintrag {


    public ORBossZagstruk() {

        category = 1;
        name = "Boss Zagstruk";
        grundkosten = getPts("Boss Zagstruk");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();

        addWarlordTraits("Goffs: Proper Killy");

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnique(true);
    }
}
