package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDSlaaneshbestien extends Eintrag {

    public CDSlaaneshbestien() {

        name = "Slaaneshbestien";
        grundkosten = 0;

        add(new AnzahlPanel(ID, randAbstand, cnt, "Slaaneshbestie", "Slaaneshbestien", 3, 9, 35));

        add(ico = new oc.Picture("oc/wh40k/images/CDSlaaneshbestien.gif"));

        complete();

    }

    @Override
    public void refreshen() {
    }
}
