package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Assault;
import oc.wh40k.units.UnitType.Infantry;

public class NecronWarriors extends Eintrag<Necrons, Assault, Infantry> {

    private final AnzahlPanel squad;

    public NecronWarriors() {
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
