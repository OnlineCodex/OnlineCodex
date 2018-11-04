package oc.wh40k.units.in;

import oc.Eintrag;

public class INInquisitorCoteaz extends Eintrag {

    public INInquisitorCoteaz() {
        name = "Inquisitor Coteaz";
        grundkosten = 100;
        add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorCoteaz.jpg"));
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
