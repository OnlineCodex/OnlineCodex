package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFateskimmer extends Eintrag {

    public CHFateskimmer() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, CHARIOT, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FATESKIMMER);

        name = "Fateskimmer";
        grundkosten = getPts("Fateskimmer");
        power = 7;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chanting Horrors", getPts("Chanting Horrors")));

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        addPsychicPowers(2, DISCIPLINE_OF_TZEENTCH);

        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();
    }
}