package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Infantry;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class Deathmarks extends Eintrag<Necrons, Elite> implements Infantry {

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