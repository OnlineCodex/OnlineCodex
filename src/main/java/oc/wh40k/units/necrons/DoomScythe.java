package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Flier;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class DoomScythe extends Eintrag<Necrons, Flier> implements Vehicle, Fly {

    public DoomScythe() {
        name = "Doom Scythe";
        grundkosten = getPts("Doom Scythe") + getPts("Tesla destructor") * 2 + getPts("Death ray");
        power = 11;

        add(ico = new oc.Picture("oc/wh40k/images/NEDoom Scythe.jpg"));

        complete();
    }
}