package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDNurglings extends Eintrag {

    AnzahlPanel Nurglings;

    public CDNurglings() {

        name = "Nurglings";
        grundkosten = 0;
        power = 3;

        add(Nurglings = new AnzahlPanel(ID, randAbstand, cnt, "Nurglings", 3, 9, getPts("Nurglings")));

        complete();

    }

    @Override
    public void refreshen() {
    }
}
