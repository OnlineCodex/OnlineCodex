package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHLordofChange extends Eintrag {

    public CHLordofChange() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, MONSTER, FLY, PSYKER, LORD_OF_CHANGE);
        name = "Lord of Change";
        grundkosten = getPts("Lord of Change");
        power = 17;
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(3, DISCIPLINE_OF_TZEENTCH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", TZEENTCH);

        complete();
    }
}
