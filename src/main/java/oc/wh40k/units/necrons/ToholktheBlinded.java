package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Source;
import oc.wh40k.units.Unique;
import oc.wh40k.units.UnitType.Infantry;
import oc.wh40k.units.necrons.Necrons.Maynarkh;

import static oc.wh40k.units.Source.SourcePublication.ImperialArmourIndexXenos;

@Source(ImperialArmourIndexXenos)
public class ToholktheBlinded extends Eintrag<Maynarkh, Hq>
        implements CharacterModel, Infantry, Necrons.Cryptek, Unique<ToholktheBlinded> {

    public ToholktheBlinded() {
        name = "Toholk the Blinded";
        grundkosten = getPts("Toholk the Blinded");
        power = 8;

        complete();
    }
}