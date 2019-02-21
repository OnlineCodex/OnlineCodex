package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;

public class NEFlayedOnes extends Eintrag {

	private final AnzahlPanel squad;

    public NEFlayedOnes() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Flayed Ones", 5, 20, getPts("Flayed Ones"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = 4 + ((squad.getModelle() > 5) ? 4 : 0)
                + ((squad.getModelle() > 10) ? 4 : 0)
                + ((squad.getModelle() > 15) ? 4 : 0);
    }
}
