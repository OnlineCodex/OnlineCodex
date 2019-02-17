package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;

public class NENecronWarriors extends Eintrag {

	private final AnzahlPanel squad;

    public NENecronWarriors() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warriors", 10, 20, getPts("Warriors") + getPts("Gauss flayer"));
        add(squad);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        power = 6 + ((squad.getModelle() > 10) ? 6 : 0);
    }
}
