package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CHSpinedChaosBeast extends Eintrag {

    public static final String SPINED_CHAOS_BEAST = "Spined Chaos Beast";

    public CHSpinedChaosBeast() {
        name = SPINED_CHAOS_BEAST;
        grundkosten = getPts(SPINED_CHAOS_BEAST);
        power = 10;

        complete();
    }
}
