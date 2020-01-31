package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMAcolytes extends Eintrag {

	private final AnzahlPanel squad;

    public IMAcolytes() {
        name = "Acolytes";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Acolytes", 1, 10, getPts("Acolytes"));
        add(squad);
    }

    @Override
    public void refreshen() {

        power = squad.getModelle();

    }
}
