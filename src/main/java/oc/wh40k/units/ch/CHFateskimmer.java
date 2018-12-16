package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFateskimmer extends Eintrag {

    OptionsEinzelUpgrade waffe1;
    OptionsEinzelUpgrade waffe2;
    RuestkammerStarter psychicPowers;

    public CHFateskimmer() {

        name = "Fateskimmer";
        grundkosten = getPts("Fateskimmer");
        power = 7;
        setKeywords(ImmutableSet.of(CHAOS, TZEENTCH, DAEMON, CHARACTER, CHARIOT, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FATESKIMMER));
        
        seperator();

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chanting Horrors", getPts("Chanting Horrors")));

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
