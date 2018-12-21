package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.Faction;
import oc.wh40k.units.MemberOf;
import oc.wh40k.units.UnitType.Infantry;

public class Deathmarks<D extends Faction> extends Eintrag
        implements Necrons, MemberOf<D>, Elite, Infantry, Necrons.Deathmarks {

    private final AnzahlPanel squad;

    public Deathmarks() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathmarks", 5, 10, getPts("Deathmarks") + getPts("Synaptic disintegrator"));
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 + ((squad.getModelle() > 5) ? 4 : 0);
    }
}