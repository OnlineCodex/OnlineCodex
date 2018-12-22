package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.LordOfWar;
import oc.wh40k.units.Source;
import oc.wh40k.units.Titanic;
import oc.wh40k.units.UnitType.Artillery;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.ImperialArmourIndexXenos;

@Source(ImperialArmourIndexXenos)
public class GaussPylon extends Eintrag<Necrons, LordOfWar>
        implements Vehicle, Artillery, Titanic {

    public GaussPylon() {
        name = "Gauss Pylon";
        grundkosten = getPts("Gauss Pylon") + getPts("Gauss annihilator") + getPts("Tesla arc");
        power = 24;

        complete();
    }
}