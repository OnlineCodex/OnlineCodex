package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.Faction;
import oc.wh40k.units.MemberOf;
import oc.wh40k.units.UnitType.Infantry;

public class FlayedOnes<D extends Faction> extends Eintrag
        implements Necrons, MemberOf<D>, Elite, Infantry, Necrons.FlayedOnes {

    private final AnzahlPanel squad;

    public FlayedOnes() {
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
