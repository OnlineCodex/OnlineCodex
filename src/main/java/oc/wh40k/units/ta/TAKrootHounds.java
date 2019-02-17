package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TAKrootHounds extends Eintrag {

	private final AnzahlPanel squad;

    public TAKrootHounds() {
        name = "Kroot Hounds";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Kroot Hounds", 4, 12, getPts("Kroot Hounds") + getPts("Ripping fangs"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 8) {
            power = 3;
        } else if (squad.getModelle() > 4) {
            power = 2;
        } else {
            power = 1;
        }
    }
}
