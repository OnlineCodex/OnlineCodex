package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHScreamers extends Eintrag {

	private final AnzahlPanel hounds;

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
        power = 4 +
                ((hounds.getModelle() > 3) ? 4 : 0) +
                ((hounds.getModelle() > 6) ? 4 : 0);
    }
}
