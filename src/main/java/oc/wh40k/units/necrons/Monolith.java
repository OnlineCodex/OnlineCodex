package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Titanic;
import oc.wh40k.units.UnitType.Vehicle;

public class Monolith extends Eintrag<Necrons, HeavySupport, Vehicle> implements Titanic, Fly {

    public Monolith() {
        name = "Monolith";
        grundkosten = getPts("Monolith") + getPts("Gauss flux arc") * 4 + getPts("Particle whip");
        power = 19;

        complete();
    }
}