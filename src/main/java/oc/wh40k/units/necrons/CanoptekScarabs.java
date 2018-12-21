package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.FastAttack;
import oc.wh40k.units.Fly;
import oc.wh40k.units.UnitType.Swarm;
import oc.wh40k.units.necrons.Necrons.Canoptek;

public class CanoptekScarabs extends Eintrag<Canoptek, FastAttack, Swarm> implements Fly {

    private final AnzahlPanel squad;

    public CanoptekScarabs() {
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