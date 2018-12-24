package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

public class CHFluxmaster extends Eintrag {

    public CHFluxmaster() {
        super(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FLUXMASTER);

        name = "Fluxmaster";
        grundkosten = getPts("Fluxmaster");
        power = 5;

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        addPsychicPowers(2, DISCIPLINE_OF_TZEENTCH);

        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();
    }
}
