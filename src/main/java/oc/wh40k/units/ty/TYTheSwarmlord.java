package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYTheSwarmlord extends Eintrag {

    public TYTheSwarmlord() {
        name = "The Swarmlord";
        grundkosten = getPts("TheSwarmlord");
        power = 15;

        addPsychicPowers(2, HIVE_MIND);

        seperator();
        
		addWarlordTraits("Alien Cunning", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
