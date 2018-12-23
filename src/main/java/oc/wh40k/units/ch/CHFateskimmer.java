package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFateskimmer extends Eintrag {

    OptionsEinzelUpgrade waffe1;
    OptionsEinzelUpgrade waffe2;
    RuestkammerStarter psychicPowers;

    public CHFateskimmer() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, CHARIOT, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FATESKIMMER);

        name = "Fateskimmer";
        grundkosten = getPts("Fateskimmer");
        power = 7;

        seperator();

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chanting Horrors", getPts("Chanting Horrors")));

        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, DISCIPLINE_OF_TZEENTCH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();
    }
}