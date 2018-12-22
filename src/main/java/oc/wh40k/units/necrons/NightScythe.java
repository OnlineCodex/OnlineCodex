package oc.wh40k.units.necrons;


import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Flier;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class NightScythe extends Eintrag<Necrons, Flier> implements Vehicle, Fly {

    public NightScythe() {
        name = "Night Scythe";
        grundkosten = getPts("Night Scythe") + getPts("Tesla destructor") * 2;
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/NECtanFragment.jpg"));

        complete();
    }
}