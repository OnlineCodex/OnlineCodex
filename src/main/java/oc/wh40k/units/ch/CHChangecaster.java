package oc.wh40k.units.ch;

import oc.Eintrag;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

public class CHChangecaster extends Eintrag {

    public CHChangecaster() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, HORROR, PSYKER, HERALD_OF_TZEENTCH, CHANGECASTER);
        name = "Changecaster";
        grundkosten = getPts("Changecaster");
        power = 4;

        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        addPsychicPowers(2, DISCIPLINE_OF_TZEENTCH);

        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
