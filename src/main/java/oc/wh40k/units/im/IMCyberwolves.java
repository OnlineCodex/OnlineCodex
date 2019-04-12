package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMCyberwolves extends Eintrag {

	private final AnzahlPanel squad;

    public IMCyberwolves() {
        grundkosten = 0;
        applyTitle = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Cyberwolf", "Cyberwolves", 1, 5, getPts("Cyberwolves"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = squad.getModelle();
    }

}
