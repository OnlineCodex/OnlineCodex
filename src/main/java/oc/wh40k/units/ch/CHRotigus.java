package oc.wh40k.units.ch;

import static oc.KeyWord.*;

import com.google.common.collect.ImmutableSet;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.PsychicPowers.ChaosGod;

public class CHRotigus extends Eintrag {

    public CHRotigus() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, MONSTER, PSYKER, GREAT_UNCLEAN_ONE, ROTIGUS);

        name = "Rotigus";
        grundkosten = getPts("Rotigus");
        power = 17;

        seperator();

        addPsychicPowers(3, ImmutableSet.of(ChaosGod.NURGLE));

        seperator();
        
        addWarlordTraits("Nurgle: Pestilent Miasma", NURGLE);
        
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
