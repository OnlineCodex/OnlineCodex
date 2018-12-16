package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHLordofChange extends Eintrag {

    OptionsUpgradeGruppe waffe1;
    OptionsEinzelUpgrade waffe2;
    RuestkammerStarter psychicPowers;

    public CHLordofChange() {

        name = "Lord of Change";
        grundkosten = getPts("Lord of Change");
        power = 17;
        setKeywords(ImmutableSet.of(CHAOS, TZEENTCH, DAEMON, CHARACTER, MONSTER, FLY, PSYKER, LORD_OF_CHANGE));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
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
