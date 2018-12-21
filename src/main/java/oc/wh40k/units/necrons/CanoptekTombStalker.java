package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.wh40k.units.AOPSlot.Elite;
import oc.wh40k.units.Source.ImperialArmourIndexXenos;
import oc.wh40k.units.UnitType;
import oc.wh40k.units.necrons.Necrons.Canoptek;

public class CanoptekTombStalker extends Eintrag<Canoptek, Elite, UnitType.Monster, ImperialArmourIndexXenos> {

    public CanoptekTombStalker() {
        name = "Canoptek Tomb Stalker";
        grundkosten = getPts("Canoptek Tomb Stalker") + getPts("Twin gauss slicers") + getPts("Automaton claws");
        power = 8;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gloom prism", getPts("Gloom prism")));

        complete();
    }
}