package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHScreamers extends Eintrag {

    AnzahlPanel hounds;

    public CHScreamers() {

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
        power = 5 +
                ((hounds.getModelle() == 6) ? 4 : 0) +
                ((hounds.getModelle() == 9) ? 8 : 0);
    }
}
