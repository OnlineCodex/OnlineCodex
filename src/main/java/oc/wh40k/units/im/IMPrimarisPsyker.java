package oc.wh40k.units.im;

import oc.Eintrag;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class IMPrimarisPsyker extends Eintrag {

    RuestkammerStarter psychicPowers;
    RuestkammerStarter warlord;

    public IMPrimarisPsyker() {
        name = "Primaris Psyker";
        grundkosten = getPts("Primaris Psyker") + getPts("Laspistol") + getPts("Force stave");
        power = 2;

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enablePsykana();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );

    }
}