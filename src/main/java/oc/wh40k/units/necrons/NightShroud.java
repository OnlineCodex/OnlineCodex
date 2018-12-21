package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Flier;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source.ImperialArmourIndexXenos;
import oc.wh40k.units.UnitType.Vehicle;

public class NightShroud extends Eintrag<Necrons, Flier, Vehicle, ImperialArmourIndexXenos> implements Fly {

    public NightShroud() {
        name = "Night Shroud";
        grundkosten = getPts("Night Shroud") + getPts("Twin tesla destructor");
        power = 13;

        complete();
    }
}