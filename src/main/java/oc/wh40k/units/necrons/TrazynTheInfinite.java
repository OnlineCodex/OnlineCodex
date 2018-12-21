package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.Hq;
import oc.wh40k.units.CharacterModel;
import oc.wh40k.units.Unique;

public class TrazynTheInfinite extends Eintrag
        implements Necrons.Nihlakh, Hq, CharacterModel, Necrons.Overlord, Unique<TrazynTheInfinite> {

    public TrazynTheInfinite() {
        name = "Trazyn the Infinite";
        grundkosten = getPts("Trazyn the Infinite");
        power = 5;
        
        seperator();

        addWarlordTraits("Nihilakh: Precognitive Strike", true);

        complete();
    }
}