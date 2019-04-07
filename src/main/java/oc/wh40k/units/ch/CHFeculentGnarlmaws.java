package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHFeculentGnarlmaws extends Eintrag {

    AnzahlPanel Gnarlmaws;

    public CHFeculentGnarlmaws() {

        name = "Feculent Gnarlmaws";
        grundkosten = 0;
        power = 3;

        add(Gnarlmaws = new AnzahlPanel(ID, randAbstand, cnt, "Feculent Gnarlmaws", 1, 3, getPts("Feculent Gnarlmaws")));

        complete();

    }

    @Override
	public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = 3 +
                ((Gnarlmaws.getModelle() == 1) ? 0 : 0) +
                ((Gnarlmaws.getModelle() == 2) ? 2 : 0) +
                ((Gnarlmaws.getModelle() == 3) ? 2 : 0);
    }

}
