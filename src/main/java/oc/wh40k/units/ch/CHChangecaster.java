package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHChangecaster extends Eintrag {

    OptionsEinzelUpgrade waffe1;
    OptionsEinzelUpgrade waffe2;

    RuestkammerStarter psychicPowers;

    public CHChangecaster() {

        name = "Changecaster";
        grundkosten = getPts("Changecaster");
        power = 4;
        setKeywords(ImmutableSet.of(CHAOS, TZEENTCH, DAEMON, CHARACTER, INFANTRY, HORROR, PSYKER, HERALD_OF_TZEENTCH, CHANGECASTER));
        
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

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
