package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.LordOfWar;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.Titanic;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class Obelisk extends Eintrag<Necrons, LordOfWar> implements Vehicle, Titanic, Fly {

    public Obelisk() {
        name = "Obelisk";
        grundkosten = getPts("Obelisk") + getPts("Tesla sphere") * 4;
        power = 22;
    }
}