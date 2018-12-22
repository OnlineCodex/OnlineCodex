package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.wh40k.units.AOPSlot;
import oc.wh40k.units.AOPSlot.FastAttack;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType;
import oc.wh40k.units.UnitType.Beasts;
import oc.wh40k.units.necrons.Necrons.Canoptek;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class CanoptekAcanthrites extends Eintrag<Canoptek, FastAttack> implements Beasts, Fly {

    private final AnzahlPanel squad;

    public CanoptekAcanthrites() {
        name = "Canoptek Acanthrites";
        grundkosten = 0;
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Acanthrites", 3, 9, getPts("Canoptek Acanthrites") + getPts("Cutting beam") + getPts("Voidblade"));

        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 6) {
            power = 27;
        } else if (squad.getModelle() > 3) {
            power = 18;
        } else {
            power = 9;
        }
    }
}