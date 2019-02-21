package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;

public class NECanoptekScarabs extends Eintrag {

	private final AnzahlPanel squad;

    public NECanoptekScarabs() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Scarabs", 3, 9, getPts("Canoptek Scarabs") + getPts("Feeder mandibles"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechSkarabaeen.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        power = 2 + ((squad.getModelle() > 3) ? 2 : 0) + ((squad.getModelle() > 6) ? 2 : 0);
    }

}
