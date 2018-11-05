package oc.wh40k.units.cs;

import oc.Eintrag;

public class CSSeuchenfestungdesNurgle extends Eintrag {

    public CSSeuchenfestungdesNurgle() {
        name = "Seuchenfestung des Nurgle";
        grundkosten = 700;

        add(ico = new oc.Picture("oc/wh40k/images/SeuchenfestungdesNurgle.gif"));


        complete();
    }

    @Override
    public void refreshen() {
    }

}
