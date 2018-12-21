package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Source.ImperialArmourIndexXenos;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Maynarkh;

public class KutlakhtheWorldKiller extends Eintrag<Maynarkh, Hq, Infantry, ImperialArmourIndexXenos>
        implements CharacterModel, Necrons.Overlord, Unique {

    public KutlakhtheWorldKiller() {
        name = "Kutlakh the World Killer";
        grundkosten = getPts("Kutlakh the World Killer");
        power = 10;

        complete();
    }
}