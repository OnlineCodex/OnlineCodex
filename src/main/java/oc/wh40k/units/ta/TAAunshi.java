package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAAunshi extends Eintrag {


    public TAAunshi() {
        name = "Aun'shi";
        grundkosten = getPts("Aun'Shi");
        power = 3;
        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));

        seperator();

        addWarlordTraits("Vior'la: Academy Luminary", true);

        complete();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnikat(true);
    }
}