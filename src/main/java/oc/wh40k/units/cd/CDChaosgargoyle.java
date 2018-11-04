package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDChaosgargoyle extends Eintrag {

    AnzahlPanel CDChaosgargoyle;

    public CDChaosgargoyle() {

        name = "Chaosgargoyle";

        grundkosten = 0;


        CDChaosgargoyle = new AnzahlPanel(ID, randAbstand, cnt, "Chaosgargoyle", 5, 20, 15);

        add(CDChaosgargoyle);


        add(ico = new oc.Picture("oc/wh40k/images/CDChaosgargoyle.gif"));


        complete();

    }

    @Override
    public void refreshen() {
    }
}
