package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;

public class NEHeavyDestroyers extends Eintrag {

	private final AnzahlPanel squad;

    public NEHeavyDestroyers() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Destroyer", "Heavy Destroyers", 1, 3, getPts("Heavy Destroyers") + getPts("Heavy gauss cannon"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEDestroyers.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        power = 3 * squad.getModelle();
    }

}
