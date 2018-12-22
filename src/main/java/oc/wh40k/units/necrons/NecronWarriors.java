package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class NecronWarriors extends Eintrag<Necrons, AOPSlot.Troops> implements Infantry {

    private final AnzahlPanel squad;

    public NecronWarriors() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warriors", 10, 20, getPts("Warriors") + getPts("Gauss flayer"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = 6 + ((squad.getModelle() > 10) ? 6 : 0);
    }
}
