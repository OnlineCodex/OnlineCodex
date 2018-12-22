package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.wh40k.units.AOPSlot.FastAttack;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Monster;
import oc.wh40k.units.necrons.Necrons.Canoptek;

import static oc.wh40k.units.Source.SourcePublication.ImperialArmourIndexXenos;

@Source(ImperialArmourIndexXenos)
public class CanoptekTombSentinel extends Eintrag<Canoptek, FastAttack> implements Monster {

    public CanoptekTombSentinel() {
        name = "Canoptek Tomb Sentinel";
        grundkosten = getPts("Canoptek Tomb Sentinel") + getPts("Exile cannon") + getPts("Automaton claws");
        power = 9;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gloom prism", getPts("Gloom prism")));

        complete();
    }
}