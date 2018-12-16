package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFluxmaster extends Eintrag {
    RuestkammerStarter psychicPowers;

    public CHFluxmaster() {

        name = "Fluxmaster";
        grundkosten = getPts("Fluxmaster");
        power = 5;
        setKeywords(ImmutableSet.of(CHAOS, TZEENTCH, DAEMON, CAVALRY, CHARACTER, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FLUXMASTER));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", true, TZEENTCH);

        complete();
    }
}
