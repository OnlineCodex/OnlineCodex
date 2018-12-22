package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.CodexNecrons;

@Source(CodexNecrons)
public class DoomsdayArk extends Eintrag<Necrons, HeavySupport> implements Vehicle, Fly {

    public DoomsdayArk() {
        name = "Doomsday Ark";
        grundkosten = getPts("Doomsday Ark") + getPts("Doomsday cannon") + getPts("Gauss flayer array") * 2;
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/NEDominatorBarke.jpg"));

        complete();
    }
}