package oc.wh40k.units.ia;

import oc.Eintrag;

public class IAInquisitorKaramazov extends Eintrag {

    public IAInquisitorKaramazov() {
        name = "Inquisitor Karamasov";
        grundkosten = 200;

        add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorKaramasov.jpg"));

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
