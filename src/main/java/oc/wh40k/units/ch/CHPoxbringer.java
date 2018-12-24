package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;
import oc.Eintrag;
import oc.wh40k.units.PsychicPowers;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_NURGLE;

public class CHPoxbringer extends Eintrag {

    public CHPoxbringer() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, PSYKER, HERALD_OF_NURGLE, POXBRINGER);
        name = "Poxbringer";
        grundkosten = getPts("Poxbringer") /*+ getPts("Balesword")*/;
        power = 4;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        addPsychicPowers(1, ImmutableSet.of(PsychicPowers.ChaosGod.NURGLE), DARK_HERETICUS, DISCIPLINE_OF_NURGLE);

        seperator();
        
        addWarlordTraits("", NURGLE);

        complete();
    }
}
