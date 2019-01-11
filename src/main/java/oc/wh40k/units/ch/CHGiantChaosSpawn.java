package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CHGiantChaosSpawn extends Eintrag {

    public static final String GIANT_CHAOS_SPAWN = "Giant Chaos Spawn";

    public CHGiantChaosSpawn() {
        name = GIANT_CHAOS_SPAWN;
        grundkosten = getPts(GIANT_CHAOS_SPAWN);
        power = 5;

        complete();
    }
}
