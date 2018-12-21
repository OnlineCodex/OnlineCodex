package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.LordOfWar;
import oc.wh40k.units.Artillery;
import oc.wh40k.units.Source.ImperialArmourIndexXenos;
import oc.wh40k.units.Titanic;
import oc.wh40k.units.UnitType.Vehicle;

public class GaussPylon extends Eintrag<Necrons, LordOfWar, Vehicle, ImperialArmourIndexXenos>
        implements Artillery, Titanic {

    public GaussPylon() {
        name = "Gauss Pylon";
        grundkosten = getPts("Gauss Pylon") + getPts("Gauss annihilator") + getPts("Tesla arc");
        power = 24;

        complete();
    }
}