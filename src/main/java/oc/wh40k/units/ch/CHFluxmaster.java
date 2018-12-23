package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFluxmaster extends Eintrag {

    public CHFluxmaster() {
        super(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FLUXMASTER);

        name = "Fluxmaster";
        grundkosten = getPts("Fluxmaster");
        power = 5;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DISCIPLINE_OF_TZEENTCH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();
    }
}
