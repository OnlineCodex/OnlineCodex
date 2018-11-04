package oc.wh40k.units.ta;

import oc.Eintrag;

public class TAAunshi extends Eintrag {

    public TAAunshi() {

        name = "Aun'shi";

        grundkosten = getPts("Aun'Shi");

        add(ico = new oc.Picture("oc/wh40k/images/Aunva.gif"));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
        power = 3;
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }
}