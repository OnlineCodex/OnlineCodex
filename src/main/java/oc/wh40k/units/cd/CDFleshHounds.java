package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CDFleshHounds extends Eintrag {

    AnzahlPanel hounds;

    public CDFleshHounds() {

        name = "Flesh Hounds";
        grundkosten = 0;
        power = 5;

        add(hounds = new AnzahlPanel(ID, randAbstand, cnt, "Flesh Hounds", 5, 20, getPts("Flesh Hounds")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = hounds.getModelle();
    }
}
