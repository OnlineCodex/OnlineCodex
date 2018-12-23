package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_NURGLE;

import com.google.common.collect.ImmutableSet;
import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHPoxbringer extends Eintrag {

    public CHPoxbringer() {
        super(CHAOS, NURGLE, DAEMON, CHARACTER, INFANTRY, PLAGUEBEARER, PSYKER, HERALD_OF_NURGLE, POXBRINGER);
        name = "Poxbringer";
        grundkosten = getPts("Poxbringer") /*+ getPts("Balesword")*/;
        power = 4;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt,
                new PsychicPowers(1, ImmutableSet.of(PsychicPowers.ChaosGod.NURGLE), DARK_HERETICUS, DISCIPLINE_OF_NURGLE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", NURGLE);

        complete();
    }
}
