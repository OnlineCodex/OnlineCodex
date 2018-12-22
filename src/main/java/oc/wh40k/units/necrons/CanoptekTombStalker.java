package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Monster;
import oc.wh40k.units.necrons.Necrons.Canoptek;

import static oc.wh40k.units.Source.SourcePublication.ImperialArmourIndexXenos;

@Source(ImperialArmourIndexXenos)
public class CanoptekTombStalker extends Eintrag<Canoptek, Elite> implements Monster {

    public CanoptekTombStalker() {
        name = "Canoptek Tomb Stalker";
        grundkosten = getPts("Canoptek Tomb Stalker") + getPts("Twin gauss slicers") + getPts("Automaton claws");
        power = 8;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gloom prism", getPts("Gloom prism")));

        complete();
    }
}