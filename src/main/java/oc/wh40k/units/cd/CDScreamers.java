package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDScreamers extends Eintrag {

    AnzahlPanel hounds;

    public CDScreamers() {

        name = "Screamers";
        grundkosten = 0;
        power = 5;

        add(hounds = new AnzahlPanel(ID, randAbstand, cnt, "Screamers", 3, 9, getPts("Screamers")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = hounds.getModelle();
    }
}
