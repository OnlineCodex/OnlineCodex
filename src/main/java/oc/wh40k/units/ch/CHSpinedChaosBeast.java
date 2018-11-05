package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CHSpinedChaosBeast extends Eintrag {

    RuestkammerStarter psychicPowers;

    public CHSpinedChaosBeast() {

        name = "Spined Chaos Beast";
        grundkosten = getPts("Spined Chaos Beast");
        power = 10;

        complete();
    }

    @Override
    public void refreshen() {
    }
}
