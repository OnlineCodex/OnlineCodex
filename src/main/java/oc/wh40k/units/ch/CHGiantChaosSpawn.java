package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CHGiantChaosSpawn extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHGiantChaosSpawn() {

        name = "Giant Chaos Spawn";
        grundkosten = getPts("Giant Chaos Spawn");
        power = 5;

        complete();
    }

    @Override
    public void refreshen() {
    }
}
